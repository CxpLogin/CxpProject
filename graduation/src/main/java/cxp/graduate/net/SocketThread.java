package cxp.graduate.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.ServletContext;
import net.sf.json.JSONObject;
import cxp.graduate.service.DeviceService;;
	
public class SocketThread implements Runnable{
	
	private ServletContext servletContext;
	private ServerSocket server;
	
	/**
	 * 传入端口号、启动服务器
	 * @param servletContext
	 * @param server
	 */
	public SocketThread(ServerSocket server,ServletContext servletContext) {
		// TODO Auto-generated constructor stub
		this.servletContext = servletContext;
		//从web.xml中context-param节点获取socket端口
		String port = this.servletContext.getInitParameter("SocketPort");
		if(server == null) {
			try {
				this.server = new ServerSocket(Integer.parseInt(port));
				System.out.println("服务器在" + port + "启动监听");
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Socket socket = server.accept();
				//3、建立连接后获取唯一验证id之后才开启线程
				BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				if(br.readLine() != null ) {
					String getClient = br.readLine();
					//建立连接后，解析json
					JSONObject object = (JSONObject) JSONObject.fromObject(getClient);	

					/*查询数据库的唯一设备码*/
					DeviceService ds = SocketUtils.getBeanByName("deviceService");
					String str = (String) object.get("identity");
					System.out.println(str);
					boolean exitCode = ds.findDefaultCode(str);
					int deviceId = ds.findDeviceId(str);
					System.out.println(deviceId);
					
					if(exitCode) {
						if(deviceId == 0) {
							PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
							pw.println("your device not activated");
							pw.flush();
							continue;//假如没有输入正确，则回到socket处继续阻塞等待下一个连接
						}else {
							System.out.println("执行接收线程");
							/*假如id验证正确执行接收信息的线程*/
							Flag flag = new Flag();
							flag.setFlag(true);//一开始设定为true
							flag.setDeviceId(deviceId);
							ReceiveThread receive = new ReceiveThread(socket,flag);
							SendThread send = new SendThread(socket,flag);
							Thread te = new Thread(receive);
							Thread ts = new Thread(send);
							te.start();
							ts.start();
						}
					}else {
						PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
						pw.println("please set right identity");
						pw.flush();
						continue;//假如没有输入正确，则回到socket处继续阻塞等待下一个连接
					}
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
