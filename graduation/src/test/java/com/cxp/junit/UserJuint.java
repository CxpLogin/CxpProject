package com.cxp.junit;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cxp.graduate.pojo.User;
import cxp.graduate.service.UserService;
import cxp.graduate.utils.CodeFactory;


@RunWith(SpringJUnit4ClassRunner.class)//帮我们创建容器
@ContextConfiguration("classpath:applicationContext.xml")//指定创建容器时使用哪个配置文件
public class UserJuint {                        
	
	@Autowired
	private UserService userService;

	/*根据用户名和密码查询用户信息*/
	@Test
	public void demo() {
		User u = new User();
		u.setU_name("陈小培");
		u.setU_pwd("123456");
		System.out.println(userService.findUser(u));
	}

	/*插入用户*/
	@Test
	public void demo1() {
		User user = new User();
		CodeFactory codeFactory = new CodeFactory();//加密密码
		user.setU_name("陈万培");
		user.setU_pwd(codeFactory.encrypt("123456"));
		user.setU_email("7572051752qq.com");
		userService.saveUser(user);
	}
	
	/*更新邮箱状态*/
	@Test
	public void demo2() {
		User user = new User();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		user.setU_retime(date);
		user.setU_emailcode("156132140134136154130138144160160130146150146154");
		user.setU_id(1);
		userService.updateCode(user);
	}
	
	/*更新激活状态*/
	@Test
	public void demo3() {
		User user = new User();
		user.setU_isact(true);
		user.setU_id(1);
		userService. updateAct(user);
	}
	
	/*获取密码*/
	@Test
	public void demo4() {
		System.out.println(userService.findUserPwd("810756933@qq.com"));
	}
}