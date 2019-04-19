package cxp.graduate.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import cxp.graduate.pojo.Sensor;
import cxp.graduate.pojo.SensorData;
import cxp.graduate.service.DeviceService;
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
			//检测客户端断开手段一，判断是否收到的消息为null
			while(true && (flag.getFlag())) {
				BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				if(br.readLine() != null) {
					String getClient = br.readLine();
					//建立连接后，解析json
					JSONObject object = (JSONObject) JSONObject.fromObject(getClient);
									
					//获取烟雾传感器、温度传感器、湿度传感器、火焰报警器、GPS地址、安装位置
					SensorData data= (SensorData) JSONObject.toBean(object,SensorData.class);
					System.out.println(data);
					
					Sensor sensor = new Sensor();
					SimpleDateFormat df = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");//设置日期格式
					String date = df.format(new Date());
					sensor.setIntime(date);
					sensor.setYanwu(data.getYanwu());
					sensor.setWendu(data.getWendu());
					sensor.setShidu(data.getShidu());
					sensor.setFlame(data.isFlame());
					sensor.setGpsaddr(data.getGpsaddr());
					sensor.setSetaddr(data.getSetaddr());
					sensor.setDid_sid(flag.getDeviceId());
					
					//查询条数
					//首先查询是否存在有十条数据
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
