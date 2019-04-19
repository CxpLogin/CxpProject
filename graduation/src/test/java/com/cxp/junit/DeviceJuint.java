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
import net.sf.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)//帮我们创建容器
@ContextConfiguration("classpath:applicationContext.xml")//指定创建容器时使用哪个配置文件
public class DeviceJuint {                        
	
	@Autowired
	private DeviceService deviceService;
	@Autowired
	private SensorService sensorService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;

	/*设备连接成功，根据设备码查询是否存在该用户*/
	@Test
	public void demo() {
		Device device = deviceService.findDeviceByCode("CKLOPD");
		System.out.println(device.getD_id());
	}
	
	/*获取传感器数据并插入*/
	@Test
	public void demo1() {
		Device device = deviceService.findDeviceByCode("CKLOPD");
		String json = "{\"identity\":\"MQTTKJ\",\"yanwu\":28,\"wendu\":28,\"shidu\":48,\"flame\":false,\"gpsaddr\":\"110.344131-25.289902\",\"setaddr\":\"parlour\"}";
		JSONObject object = (JSONObject) JSONObject.fromObject(json);
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
		sensor.setDid_sid(device.getD_id());
		
		//插入数据
		sensorService.insertSensorData(sensor);
	}
	
	/*查询指令库若发生改变则发送更改指令并置标志位为0*/
	@Test
	public void demo2() {
		Device device = deviceService.findDeviceByCode("CKLOPD");
		Directive directive = orderService.findDirectiveFlag(device.getD_id());
		if(directive.isC_flag()) {
			JSONObject json = JSONObject.fromObject(directive);
			System.out.println(json.toString());
			directive.setC_flag(false);
			orderService.updateDirectiveFlag(directive);
		}
	}
	
	/*模拟用户控制指令*/
	@Test
	public void demo3() {
		//用户打开报警器
		User user = new User();
		user.setU_id(1);//模拟获取用户id
		
		//根据用户id获取设备,
		List<Device> devices = deviceService.findDeviceByUid(user.getU_id());
		for (Device device : devices) {
			System.out.println(device);
		}
		
		//根据设备号操作指令	
		Directive directive = new Directive();
		directive.setC_alarm(true);
		directive.setC_relay(false);
		directive.setC_flag(true);
		directive.setDid_oid(devices.get(0).getD_id());
		orderService.updataDirective(directive);
	}
	
	/*激活设备*/
	@Test
	public void demo4() {
		User user = new User();
		user.setU_id(1);
		System.out.println(deviceService.findDefaultCode("CKLOPD"));
		Device device = new Device();
		System.out.println(deviceService.findDeviceByCode("CKLOPD"));
		
		//首先根据用户id将激活状态更新
		user.setU_isact(true);
		userService.updateActDevice(user);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		device.setD_code("MVPYLK");
		device.setD_activattime(date);
		device.setUid_did(user.getU_id());
		int did = deviceService.saveDevice(device);
		System.out.println(did);
	}
	
	/*获取用户下所有设备的id*/
	@Test
	public void demo5() throws MalformedURLException {
		User user = new User();
		user.setU_id(1);
		
		List<Device> devices = deviceService.findDeviceByUid(user.getU_id());
		//List<Sensor> list = null ;list = sensorService.selectSensorSetAddr(devices.get(i).getD_id());
		//遍历所有id去获取传感器的的地址
		Device device = new Device();
		BaiduMapUtils baidu = new BaiduMapUtils();
		for (int i = 0; i < devices.size(); i++) {
			List<Sensor> list = sensorService.selectSensorSetAddr(devices.get(i).getD_id());
			
			if(list.get(i).getSetaddr().equals("parlour")) {
				String jinweidu = list.get(i).getGpsaddr();
				String[]  strs=jinweidu.split("-");
				String jingdu = strs[0];
				String weidu = strs[1];
				device.setD_id(devices.get(i).getD_id());
				device.setD_physics(jinweidu);
				device.setD_setaddr("客厅");		
				device.setD_state(true);
				device.setD_instaladdr(baidu.getPosition(jingdu,weidu));
				deviceService.updateSetAddr(device);
			}else if(list.get(i).getSetaddr().equals("bedroom")) {
				String jinweidu = list.get(i).getGpsaddr();
				String[]  strs=jinweidu.split("-");
				String jingdu = strs[0];
				String weidu = strs[1];
				device.setD_id(devices.get(i).getD_id());
				device.setD_physics(jinweidu);
				device.setD_setaddr("卧室");	
				device.setD_state(true);
				device.setD_instaladdr(baidu.getPosition(jingdu,weidu));
				deviceService.updateSetAddr(device);
			}else if(list.get(i).getSetaddr().equals("kitchen")) {
				String jinweidu = list.get(i).getGpsaddr();
				String[]  strs=jinweidu.split("-");
				String jingdu = strs[0];
				String weidu = strs[1];
				device.setD_id(devices.get(i).getD_id());
				device.setD_physics(jinweidu);
				device.setD_setaddr("厨房");	
				device.setD_state(true);
				device.setD_instaladdr(baidu.getPosition(jingdu,weidu));
				deviceService.updateSetAddr(device);
			}
			
		}
		//查询客厅、且注册时间排序且未状态为1
		System.out.println(device);	
		device.setD_setaddr("客厅");
		device.setD_state(true);
		device.setUid_did(user.getU_id());
		int d_id = deviceService.findParlourOn(device);
		if(d_id != 0) {
			System.out.println(sensorService.selectSensorData(d_id));
		}
		System.out.println(d_id);
		//System.out.println(sensorService.selectSensorData(1));
	}
	
	/*获取用户下所有设备的id*/
	@Test
	public void demo6() throws MalformedURLException {
		User user = new User();
		user.setU_id(1);
		
		List<Device> devices = deviceService.findDeviceByUid(user.getU_id());
		//List<Sensor> list = null ;list = sensorService.selectSensorSetAddr(devices.get(i).getD_id());
		//遍历所有id去获取传感器的的地址
		Device device = new Device();
		BaiduMapUtils baidu = new BaiduMapUtils();
		for (int i = 0; i < devices.size(); i++) {
			List<Sensor> list = sensorService.selectSensorSetAddr(devices.get(i).getD_id());
			
			if(list.get(i).getSetaddr().equals("parlour")) {
				String jinweidu = list.get(i).getGpsaddr();
				String[]  strs=jinweidu.split("-");
				String jingdu = strs[0];
				String weidu = strs[1];
				device.setD_id(devices.get(i).getD_id());
				device.setD_physics(jinweidu);
				device.setD_setaddr("客厅");		
				device.setD_state(true);
				device.setD_instaladdr(baidu.getPosition(jingdu,weidu));
				deviceService.updateSetAddr(device);
			}else if(list.get(i).getSetaddr().equals("bedroom")) {
				String jinweidu = list.get(i).getGpsaddr();
				String[]  strs=jinweidu.split("-");
				String jingdu = strs[0];
				String weidu = strs[1];
				device.setD_id(devices.get(i).getD_id());
				device.setD_physics(jinweidu);
				device.setD_setaddr("卧室");	
				device.setD_state(true);
				device.setD_instaladdr(baidu.getPosition(jingdu,weidu));
				deviceService.updateSetAddr(device);
			}else if(list.get(i).getSetaddr().equals("kitchen")) {
				String jinweidu = list.get(i).getGpsaddr();
				String[]  strs=jinweidu.split("-");
				String jingdu = strs[0];
				String weidu = strs[1];
				device.setD_id(devices.get(i).getD_id());
				device.setD_physics(jinweidu);
				device.setD_setaddr("厨房");	
				device.setD_state(true);
				device.setD_instaladdr(baidu.getPosition(jingdu,weidu));
				deviceService.updateSetAddr(device);
			}
			
		}
		//查询客厅、且注册时间排序且未状态为1
		System.out.println(device);	
		device.setD_setaddr("卧室");
		device.setD_state(true);
		device.setUid_did(user.getU_id());
		int d_id = deviceService.findBedRoomOn(device);
		if(d_id != 0) {
			System.out.println(sensorService.selectSensorData(d_id));
		}
		System.out.println(d_id);
		//System.out.println(sensorService.selectSensorData(1));
	}
	
}