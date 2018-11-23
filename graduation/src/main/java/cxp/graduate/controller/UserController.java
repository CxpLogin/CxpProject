package cxp.graduate.controller;

import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cxp.graduate.pojo.User;

/**
 * 
 * @ClassName:  UserController   
 * @Description:主要处理普通用户业务逻辑 
 * @date:   2018年11月23日 下午5:36:33
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(User user) {
		System.out.println(user.getUserName());
		System.out.println(user.getUserPwd());
		return null;
	}
}
