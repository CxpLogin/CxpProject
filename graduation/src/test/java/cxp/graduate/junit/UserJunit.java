package cxp.graduate.junit;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cxp.graduate.mapper.UserMapper;
import cxp.graduate.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)//帮我们创建容器
@ContextConfiguration("classpath:applicationContext.xml")//指定创建容器时使用哪个配置文件
public class UserJunit {                        
	
	@Autowired
	private UserMapper userMapper;
	
	/*检验查询*/
	@Test
	public void demo() {
		User user = new User();
		user.setUserName("陈");
		user.setUserPwd("123456");
		User u = userMapper.findUser(user);
		System.out.println(u);
	}
	
	/*一个用户具有多个设备，测试查询用户名下的设备*/
	@Test
	public void demo1() {
		List<User> list = userMapper.selectUserDevice(1);
		for (User user : list) {
			System.out.println(user);
			for (int i = 0; i < list.size(); i++) {
				System.out.println(user.getDevices().get(i).getDeviceId());
			}
		}
	}
	
	/*一个用户只有一次注册*/
	@Test
	public void demo2() {
		List<User> list = userMapper.selectUserRegist(1);
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	/*一个用户只有一次注册*/
	@Test
	public void demo3() {
		User user = new User();
		user.setUserName("张三");
		user.setUserPwd("654321");
		userMapper.insertUser(user);
		System.out.println(user.getUserId());
	}
	
}