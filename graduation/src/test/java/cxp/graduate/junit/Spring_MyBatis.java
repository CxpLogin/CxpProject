package cxp.graduate.junit;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cxp.graduate.mapper.AdminMapper;
import cxp.graduate.pojo.Admin;


public class Spring_MyBatis {
	
//	public ApplicationContext applicationContext;
	
	@Before  
    public void before() {  
//		applicationContext=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }  
	
	@Test
	public void demo() {
//		AdminMapper adminMapper=(AdminMapper) applicationContext.getBean("adminMapper");

//		List<Admin> ad = (List<Admin>) adminMapper.findAdmins();
		
//		System.out.println(ad);
	}
}
