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
import cxp.graduate.pojo.Days;


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
}
