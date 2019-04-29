package cxp.graduate.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import cxp.graduate.pojo.Directive;
import cxp.graduate.service.DeviceService;
import cxp.graduate.service.OrderService;
import net.sf.json.JSONObject;

/**
 * 
 * @ClassName:  SendThread   
 * @Description:这是一个发送消息线程，当用户输入的唯一id正确之后该线程启动
 * @date:   2018年11月9日 下午10:08:40
 */
public class SendThread implements Runnable{

	private Socket socket;
	private Flag flag;
	
	public SendThread(Socket socket,Flag flag) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		this.flag = flag;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true && (flag.getFlag())) {
				PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				OrderService os = SocketUtils.getBeanByName("orderService");
				Directive directive = os.findDirectiveFlag(flag.getDeviceId());
				if(directive.isC_flag()) {
					JSONObject json = JSONObject.fromObject(directive);
					System.out.println(json.toString());
					pw.println(json.toString());
					pw.flush();
					directive.setC_flag(false);
					os.updateDirectiveFlag(directive);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
