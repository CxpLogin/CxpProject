package cxp.graduate.junit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.CharUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cxp.graduate.mapper.DaysMapper;
import cxp.graduate.pojo.Days;
import cxp.graduate.service.DaysService;
import net.sf.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)//帮我们创建容器
@ContextConfiguration("classpath:applicationContext.xml")//指定创建容器时使用哪个配置文件
public class DaysJunit {                        
	
	@Autowired
	private DaysService daysService;
	
	@Autowired
	private DaysMapper daysMapper;
	
	/*检验查询*/
	@Test
	public void demo() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		List<Days> list = daysService.getDataByDay(date);
		for (Days days : list) {
			System.out.println(days);
		}
	}
	@Test
	public void fun() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		Days days = daysMapper.selectDay(date);
		System.out.println(days);
	}
	
	/*检验插入数据*/
	@Test
	public void demo1() {
		Days days = new Days();
		String date = "2018-11-20";
		days.setD_dat(date);
		days.setD_smoke(25.23f);
		days.setD_temperature(16.22f);
		days.setD_infrared(30.33f);
		daysMapper.saveData(days);
	}
	
	/*使用json数据插入*/
	@Test
	public void demo2() {
		String objectJson = "{\"d_dat\":\"2018-11-23\",\"d_smoke\":25.23,\"d_infrared\":30.33,\"d_temperature\":16.22}";
		JSONObject jsonObject = JSONObject.fromObject(objectJson);
		Days days = (Days) JSONObject.toBean(jsonObject,Days.class);
		System.out.println(days.getD_dat());
		System.out.println(days.getD_smoke());
		System.out.println(days.getD_temperature());
		System.out.println(days.getD_infrared());
		daysMapper.saveData(days);
	}
	
	/*使用json数据插入*/
	@Test
	public void demo3() {
		String objectJson = "{\"d_dat\":\"2018-11-24\",\"d_smoke\":25.23,\"d_infrared\":30.33,\"d_temperature\":16.22}";
		JSONObject jsonObject = JSONObject.fromObject(objectJson);
		Days days = (Days) JSONObject.toBean(jsonObject,Days.class);
		System.out.println(days.getD_dat());
		System.out.println(days.getD_smoke());
		System.out.println(days.getD_temperature());
		System.out.println(days.getD_infrared());
		if(daysService.saveData(days)) {
			System.out.println("插入成功");
		}
	}
}