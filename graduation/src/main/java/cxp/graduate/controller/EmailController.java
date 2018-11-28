package cxp.graduate.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cxp.graduate.service.EmailService;
import cxp.graduate.utils.CodeFactory;

/**
 * 
 * @ClassName:  EmailController   
 * @Description:激活邮箱 
 * @date:   2018年11月28日 上午11:22:00
 */
@Controller
@RequestMapping("/user")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/email")
	public String email(HttpServletRequest request) {
		//1、获取链接中邮箱和加密串
		String emailName = request.getParameter("email");
		String code = request.getParameter("code");
		
		//2、根据邮箱获取数据表中的激活码与传递的加密码进行比较
		String getCode = emailService.findEmailCode(emailName);
		if(CodeFactory.authenticatePassword(code, getCode)) {
			//3、成功则更新表，并返回
			emailService.updateEmailState(emailName);
			return "redirect:/index.html";	
		}
		return "redirect:/login.html";		
	}
}
