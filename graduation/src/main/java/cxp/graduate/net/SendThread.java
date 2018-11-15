package cxp.graduate.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

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
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pw.println("sss");
				pw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
