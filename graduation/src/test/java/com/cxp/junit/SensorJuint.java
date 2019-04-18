package com.cxp.junit;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cxp.graduate.mapper.SensorMapper;
import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.Sensor;
import cxp.graduate.service.SensorService;
import net.sf.json.JSONArray;


@RunWith(SpringJUnit4ClassRunner.class)//帮我们创建容器
@ContextConfiguration("classpath:applicationContext.xml")//指定创建容器时使用哪个配置文件
public class SensorJuint {                        
	
	@Autowired
	private SensorMapper sensorMapper;
	@Autowired
	private SensorService sensorService;
	
	/*查询数据库是否有十条数据*/
	@Test
	public void demo() {
		//测试sensorMapper
		/*
		int num = sensorMapper.selectSensorCount(1);
		System.out.println(num);
		*/
	}
	
	
	
	/*插入数据的时候删除第一条数据*/
	@Test
	public void demo1() {
		Sensor sensor = new Sensor();
		SimpleDateFormat df = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");//设置日期格式
		String date = df.format(new Date());
		sensor.setIntime(date);
		sensor.setYanwu((float) 22.22);
		sensor.setWendu((float) 22.22);
		sensor.setShidu((float) 25.22);
		sensor.setFlame(false);
		sensor.setGpsaddr("广西桂林");
		sensor.setSetaddr("客厅");
		sensor.setDid_sid(1);
		//首先查询是否存在有十条数据
		int count = sensorMapper.selectSensorCount(1);
		if(count == 10) {
			sensorMapper.deleteFirstTime(1);
		}
		System.out.println(count);
		System.out.println(sensor);
		sensorMapper.insertData(sensor);
	}
	
	//获取设备id
	@Test
	public void demo2() {
		Device device = new Device();
		device.setUid_did(1);
		device.setD_setaddr("客厅");
		int d_id = sensorMapper.selectByUidAndSetAddr(device);
		System.out.println(d_id);
	}

	/*将获取的list集合转成json字符串*/
	@Test
	public void demo3() {
		/*
		//mapper测试
		List<Sensor> list = sensorMapper.selectByDid(1);
		JSONArray jsonArray = JSONArray.fromObject(list);
		System.out.println(jsonArray.toString());
		*/
		//service测试
		String str = sensorService.selectSensorData(1);
		System.out.println(str);
		
	}
	
	
}