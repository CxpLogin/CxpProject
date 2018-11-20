package cxp.graduate.junit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cxp.graduate.pojo.Days;
import cxp.graduate.service.DaysService;

@RunWith(SpringJUnit4ClassRunner.class)//帮我们创建容器
@ContextConfiguration("classpath:applicationContext.xml")//指定创建容器时使用哪个配置文件
public class DaysJunit {                        
	
	@Autowired
	private DaysService daysService;
	
	@Test
	public void demo() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		List<Days> list = daysService.getDataByDay(date);
		for (Days days : list) {
			System.out.println(days);
		}
	}
}