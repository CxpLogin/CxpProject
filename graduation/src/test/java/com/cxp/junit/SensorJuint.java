package com.cxp.junit;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.Directive;
import cxp.graduate.pojo.Sensor;
import cxp.graduate.pojo.SensorData;
import cxp.graduate.pojo.User;
import cxp.graduate.service.DeviceService;
import cxp.graduate.service.OrderService;
import cxp.graduate.service.SensorService;
import cxp.graduate.service.UserService;
import cxp.graduate.utils.BaiduMapUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)//帮我们创建容器
@ContextConfiguration("classpath:applicationContext.xml")//指定创建容器时使用哪个配置文件
public class SensorJuint {                        
	
	@Autowired
	private DeviceService deviceService;
	@Autowired
	private SensorService sensorService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;

	//模拟接收线程接收到数据并插入数据库
	@Test
	public void demo() {
		String str = "{\"identity\":\"MQTTKJ\",\"yanwu\":23,\"wendu\":20,\"shidu\":40,\"flame\":false,\"gpsaddr\":\"110.344131-25.289902\",\"setaddr\":\"parlour\"}";
		JSONObject object = (JSONObject) JSONObject.fromObject(str);
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
		sensor.setDid_sid(1);
		
		sensorService.insertSensorData(sensor);		
	}
	
	//模拟发送线程指令操作
	@Test
	public void demo1() {
		Directive directive = orderService.findDirectiveFlag(1);
		if(directive.isC_flag()) {
			JSONObject json = JSONObject.fromObject(directive);
			System.out.println(json.toString());			
			orderService.updateDirectiveFlag(directive);
		}
	}
	
	
}