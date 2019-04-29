package cxp.graduate.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import cxp.graduate.pojo.Sensor;
import cxp.graduate.pojo.SensorData;
import cxp.graduate.service.SensorService;
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
	
	public ReceiveThread(Socket socket,Flag flag) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		this.flag = flag;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true && (flag.getFlag())) {
				BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				if(br.readLine() != null) {
					String getClient = br.readLine();
					JSONObject object = (JSONObject) JSONObject.fromObject(getClient);
					
					SensorData data= (SensorData) JSONObject.toBean(object,SensorData.class);
					
					Sensor sensor = new Sensor();
					SimpleDateFormat df1 = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
					String intime = df1.format(new Date());
					SimpleDateFormat df2 = new SimpleDateFormat("yyyy:MM:dd");
					String indate = df2.format(new Date());
					sensor.setIntime(intime);
					sensor.setIndate(indate);
					sensor.setYanwu(data.getYanwu());
					sensor.setWendu(data.getWendu());
					sensor.setShidu(data.getShidu());
					sensor.setFlame(data.isFlame());
					sensor.setGpsaddr(data.getGpsaddr());
					sensor.setSetaddr(data.getSetaddr());
					sensor.setDid_sid(flag.getDeviceId());

					SensorService ss = SocketUtils.getBeanByName("sensorService");
					ss.insertSensorData(sensor);					
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
