package com.cxp.junit;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cxp.graduate.mapper.DeviceMapper;
import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.Devices;
import cxp.graduate.pojo.MapBean;
import cxp.graduate.pojo.Sensor;
import cxp.graduate.service.DeviceService;
import cxp.graduate.service.SensorService;
import cxp.graduate.utils.BaiduMapUtils;
import net.sf.json.JSONArray;


@RunWith(SpringJUnit4ClassRunner.class)//帮我们创建容器
@ContextConfiguration("classpath:applicationContext.xml")//指定创建容器时使用哪个配置文件
public class DeviceJuint {                        
	
	@Autowired
	private DeviceService deviceService;
	@Autowired
	private DeviceMapper deviceMapper;
	
	@Autowired
	private SensorService sensorService;

	/*获取数据库的出厂编码*/
	@Test
	public void demo() {
		//deviceMapper测试
		/*
		String str = deviceMapper.findDefaultCode("MQTTKJ");
		System.out.println(str);
		*/
		//deviceService测试
		boolean b =deviceService.findDefaultCode("MQTTKJ");
		System.out.println(b);
	}
	
	/*根据出厂编码获取设备id*/
	@Test
	public void demo1() {
		//deviceMapper测试
		int id = deviceMapper.findDeviceId("MQTTKJ");
		System.out.println(id);
	}
	
	/*根据出厂编码获取设备*/
	@Test
	public void demo3() {
		//deviceMapper测试
		/*
		Device device = deviceMapper.findDevice("MQTTKJ");
		System.out.println(device);
		*/
		int id = deviceService.findDeviceId("MVPASD");
		System.out.println(id);
	}
	
	
	/*根据不同的数量进行不同的显示*/
	@Test
	public void demo4() throws MalformedURLException {
		Devices devices = deviceService.selectUserDevice(1);
		System.out.println(devices);
		MapBean mapbean = new MapBean();
		BaiduMapUtils baidu = new BaiduMapUtils();
		Device device = new Device();
		if(devices.getParlour() == 0) {
			for (int i = 0; i < devices.getDevices(); i++) {
				if(deviceService.findDeviceSetAddr((int) devices.getDeviceId().get(i)) == null) {
					System.out.println(i);
					List<Sensor> list = sensorService.selectSensorSetAddr((int) devices.getDeviceId().get(i));
					mapbean.setSetaddr(list.get(i).getSetaddr());
					mapbean.setGpsaddr(list.get(i).getGpsaddr());
				}
			}
			device.setD_id(1);
			System.out.println(mapbean);
			if(mapbean.getSetaddr().equals("parlour")) {
				device.setD_setaddr("客厅");
			}
			device.setD_setaddr(mapbean.getSetaddr());
			device.setD_physics(mapbean.getGpsaddr());
			String jinweidu = mapbean.getGpsaddr();
			String[]  strs=jinweidu.split("-");
			String jingdu = strs[0];
			String weidu = strs[1];
			device.setD_instaladdr(baidu.getPosition(jingdu,weidu));
			deviceService.updateSetAddr(device);
		}
	}
	
	/*根据出厂码查询设备*/
	@Test
	public void demo5() {
		/*
		Device device = deviceMapper.findDeviceCode("MQTTKJ");
		System.out.println(device);
		*/
		System.out.println(deviceService.findDeviceCode("MQTTKJ"));
	}
	
	/*插入设备*/
	@Test
	public void demo6() {
		Device device = new Device();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		device.setD_code("RTYBKU");
		device.setD_activattime(date);
		device.setUid_did(1);
		deviceService.saveDevice(device);
	}
	
	/*根据id查询安装地址*/
	@Test
	public void demo7() {
		System.out.println(deviceMapper.findDeviceSetAddr(1));
	}
	
	
}