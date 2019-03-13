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
import cxp.graduate.pojo.Sensor;
import net.sf.json.JSONArray;


@RunWith(SpringJUnit4ClassRunner.class)//帮我们创建容器
@ContextConfiguration("classpath:applicationContext.xml")//指定创建容器时使用哪个配置文件
public class SensorJuint {                        
	
	@Autowired
	private SensorMapper sensorMapper;
	
	/*获取10条数据转成list集合*/
	@Test
	public void demo() {
		List<Sensor> list = sensorMapper.selectByDid(1);
		for (Sensor sensors : list) {
			System.out.println(sensors);
		}
		//获取时间
		for(int i = 0;i < list.size();i++) {
			System.out.println(list.get(i).getIntime());
		}
		//获取烟雾传感器数据
		for(int i = 0;i < list.size();i++) {
			System.out.println(list.get(i).getMq2());
		}
	}
	
	/*查询当前数据库有多少条数据*/
	@Test
	public void demo1() {
		System.out.println(sensorMapper.selectCount(1));
	}
	
	/*删除时间最远的一条数据*/
	@Test
	public void demo2() {
		sensorMapper.deleteFirstTime(1);
	}
	
	/*插入数据的时候删除第一条数据*/
	@Test
	public void demo3() {
		Sensor sensor = new Sensor();
		SimpleDateFormat df = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");//设置日期格式
		String date = df.format(new Date());
		sensor.setIntime(date);
		sensor.setMq2((float) 22.65);
		sensor.setDht11((float) 22.65);
		sensor.setFlame((float) 25.62);
		sensor.setDid_sid(1);
		//首先查询是否存在有十条数据
		int count = sensorMapper.selectCount(1);
		if(count == 10) {
			sensorMapper.deleteFirstTime(1);
		}
		sensorMapper.insertTime(sensor);
	}
	
	/*将获取的list集合转成json字符串*/
	@Test
	public void demo4() {
		List<Sensor> list = sensorMapper.selectByDid(1);
		JSONArray jsonArray = JSONArray.fromObject(list);
		System.out.println(jsonArray.toString());
	}
	
}