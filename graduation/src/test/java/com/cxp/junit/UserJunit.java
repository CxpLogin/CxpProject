package com.cxp.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cxp.graduate.mapper.UserMapper;
import cxp.graduate.pojo.User;
import cxp.graduate.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)//帮我们创建容器
@ContextConfiguration("classpath:applicationContext.xml")//指定创建容器时使用哪个配置文件
public class UserJunit {                        
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserService userService;

	/*根据用户名和密码查询用户信息*/
	@Test
	public void demo() {
		User u = new User();
		u.setUserName("陈小培");
		u.setUserPwd("158130156136138152140150152140158140160130146136");
		User user = userMapper.findUserByName(u);
		System.out.println(user);
	}

	/*根据用户名是否存在用户*/
	@Test
	public void demo1() {
		User user = userMapper.selectUserByName("陈小培");
		System.out.println(user);
	}
	
	/*查询是否存在注册过的邮箱*/
	@Test
	public void demo2() {
		String user = userMapper.findUserEmail("810756933@qq.com");
		System.out.println(user);
	}
	
	/*根据用户ID查询是否激活设备*/
	@Test
	public void demo3() {
		User user = userMapper.findDeviceByID(1);
		System.out.println(user.getDevices().get(0).isActivate());
	}	
}