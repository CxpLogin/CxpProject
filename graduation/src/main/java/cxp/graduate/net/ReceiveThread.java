package cxp.graduate.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import cxp.graduate.pojo.Days;
import cxp.graduate.service.DaysService;
import net.sf.json.JSONObject;

/**
 * 
 * @ClassName:  ReceiveThread   
 * @Description:这是接收信息的线程，假如客户端验证通过则开启此线程  
 * @date:   2018年11月9日 下午9:53:11
 */

public class ReceiveThread implements Runnable{

	private Socket socket;
	private Flag flag;
	private String msg = "";
	
	public ReceiveThread(Socket socket,Flag flag) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		this.flag = flag;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		try {
			//检测客户端断开手段一，判断是否收到的消息为null
			while(true && (flag.getFlag())) {
				BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				if((msg = br.readLine() )!= null) {
					System.out.println(msg);
					String jsonMsg = msg;
					JSONObject jsonObject = JSONObject.fromObject(jsonMsg);
					Days days = (Days) JSONObject.toBean(jsonObject,Days.class);
					System.out.println(days);
					DaysService ds = SocketUtils.getBeanByName("daysService");
					ds.saveData(days);
				}else {
					flag.setFlag(false); 
				}	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag.setFlag(false); 
		}
	}
}
