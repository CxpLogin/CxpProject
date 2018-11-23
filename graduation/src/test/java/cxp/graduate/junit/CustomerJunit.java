package cxp.graduate.junit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cxp.graduate.mapper.DaysMapper;
import cxp.graduate.net.SocketUtils;
import cxp.graduate.pojo.Days;
import cxp.graduate.service.DaysService;


public class CustomerJunit {
	
	public ApplicationContext applicationContext;
	
	@Before  
    public void before() {  
		applicationContext=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }  
	
	@Test
	public void demo() {
		DaysMapper daysMapper = (DaysMapper) applicationContext.getBean("daysMapper");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());

		List<Days> days = daysMapper.getDataByDay(date);
		for (Iterator iterator = days.iterator(); iterator.hasNext();) {
			Days days2 = (Days) iterator.next();
			System.out.println(days2);
		}
	}
	
	@Test
	public void fun() {
		DaysService ds = SocketUtils.getBeanByName("daysService");
		Days days = new Days();
		String date = "2018-11-27";
		days.setD_dat(date);
		days.setD_smoke(25.23f);
		days.setD_temperature(16.22f);
		days.setD_infrared(30.33f);
		ds.saveData(days);
	}
}
