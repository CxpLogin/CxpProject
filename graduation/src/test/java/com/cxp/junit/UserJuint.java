package com.cxp.junit;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.Page;
import cxp.graduate.pojo.Rows;
import cxp.graduate.pojo.Sensor;
import cxp.graduate.pojo.User;
import cxp.graduate.service.DeviceService;
import cxp.graduate.service.SensorService;
import cxp.graduate.service.UserService;
import cxp.graduate.utils.CodeFactory;
import cxp.graduate.utils.JsonUtils;
import net.sf.json.JSONObject;


@RunWith(SpringJUnit4ClassRunner.class)//帮我们创建容器
@ContextConfiguration("classpath:applicationContext.xml")//指定创建容器时使用哪个配置文件
public class UserJuint {                        
	
	@Autowired
	private UserService userService;
	@Autowired
	private DeviceService deviceService;
	@Autowired
	private SensorService sensorService;

	/*用户注册功能*/
	@Test
	public void demo() {
		User user = new User();
		user.setU_name("张三");
		user.setU_pwd("158130156136138152140150152140158140160130146136");
		user.setU_email("810756934@qq.com");
		//1、首先匹配用户名是否使用过
		//User exitUser = userService.findUserByName(user.getU_name());
		//System.out.println(exitUser);
		//2、其次匹配用户邮箱是否被使用过
		//User exitUser = userService.findUserByEmainl(user.getU_email());
		//System.out.println(exitUser);
		//3、以上均无，保存用户
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
//		String date = df.format(new Date());
//		user.setU_retime(date);
//		int uid = userService.saveUser(user);
//		System.out.println(uid);
	}
	
	/*用户登录功能*/
	@Test
	public void demo1() {
		User user = new User();
		user.setU_name("王五");
		user.setU_pwd("123456");
		User findUser = userService.findUser(user);
		System.out.println(findUser);
		//假如存在判断邮箱是否激活
		if(findUser.getU_emailcode() == null) {
			System.out.println("邮箱未注册");
		}
		//判断设备是否激活
		if(!findUser.isU_isact()) {
			System.out.println("未激活");
		}
	}
	
	/*模拟用户添加设备*/
	@Test
	public void demo2() {
		User user = new User();
		user.setU_id(1);
		
		//默认不操作激活码
		Device device = new Device();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		device.setD_code("YTRVDQ");
		device.setD_activattime(date);
		device.setUid_did(user.getU_id());
		int did = deviceService.saveDevice(device);
		System.out.println(did);
	}
	
	/*根据用户id查询设备*/
	@Test
	public void demo3() {
		User user = userService.findUserByName("陈小培");
		System.out.println(user.getDevices());
	}
	
}