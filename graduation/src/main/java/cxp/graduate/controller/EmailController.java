package cxp.graduate.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.User;
import cxp.graduate.service.DeviceService;
import cxp.graduate.service.UserService;
import cxp.graduate.utils.CodeFactory;
import cxp.graduate.utils.EmailValidateCode;
import cxp.graduate.utils.UserResultUtils;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class EmailController {
	/**
	 * @ClassName：EmailController
	 * @Description: 邮件激活设备
	 * @date:
	 */
	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private UserService userService;
	
	UserResultUtils result = new UserResultUtils();
	
	//发送激活码到邮箱
	@RequestMapping(value="email",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String email(@RequestBody User u,HttpSession session) {
		//获得提交的激活码
		String emailcode = u.getU_emailcode();
		System.out.println(emailcode);
		String sessioncode = (String) session.getAttribute("activateCode");
		if(!(CodeFactory.authenticatePassword(emailcode,sessioncode))) {
			result.setKey("success");
			result.setMessage(result.AtiCode);
			JSONObject json = JSONObject.fromObject(result);
			return json.toString();
		}
		//更新注册时间和注册码
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		User user = (User) session.getAttribute("user");
		user.setU_retime(date);
		user.setU_emailcode(emailcode);
		userService.updateEmailCode(user);
		result.setKey("success");
		result.setMessage(result.Activate);
		JSONObject json = JSONObject.fromObject(result);
		return json.toString();
	}
	
	
}
