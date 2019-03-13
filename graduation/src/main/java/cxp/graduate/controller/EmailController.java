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

import cxp.graduate.pojo.Code;
import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.UniCode;
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
	public String email(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		//获取当前用户的用户名
		String uname =  (String) session.getAttribute("username");
		if(!(request.getParameter("email").equals(userService.findUser(uname).getUserEmail()))) {
			result.setKey("success");
			result.setMessage(result.EmailError);
			JSONObject json = JSONObject.fromObject(result);
			return json.toString();
		}
		//生成加密文
		CodeFactory codeFactory = new CodeFactory();
		String  code = codeFactory.getCode();//生成随机字符串
		session.setAttribute("activateCode", code);
		String DeCode = CodeFactory.encrypt(code);//生成加密文
		System.out.println( "生成的随机code：" + DeCode);

		//以当前用户的邮箱进行邮件的发送
		EmailValidateCode evc = new EmailValidateCode();
		evc.sendEmail(request.getParameter("email"), DeCode);
		result.setKey("success");
		result.setMessage(result.SendEmail);
		JSONObject json = JSONObject.fromObject(result);
		return json.toString();
	}
	
	/**
	 * 
	* @Title: emailCode
	* @Description: 
	* @param：
	* @return：
	* @throws：
	 */
	@RequestMapping(value="emailCode",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String emailCode(@RequestBody Device deviceCode,HttpSession session) {
		System.out.println(deviceCode.getUniqueID());
		//查询数据库是否存在该设备码，若存在是否有设备在使用
		String devStr = deviceService.compareCode(deviceCode.getUniqueID());
		if(devStr.equals(result.UniCodeMsg1)) {
			result.setKey("success");
			result.setMessage(result.UniCodeMsg1);
			JSONObject json = JSONObject.fromObject(result);
			return json.toString();
		}else if(devStr.equals(result.UniCodeMsg2)) {
			result.setKey("success");
			result.setMessage(result.UniCodeMsg2);
			JSONObject json = JSONObject.fromObject(result);
			return json.toString();
		}else if(devStr.equals(result.UniCodeMsg3)) {
			//从session域中获取code
			if(!(CodeFactory.authenticatePassword(deviceCode.getActivateCode(), (String)session.getAttribute("activateCode")))) {
				result.setKey("success");
				result.setMessage(result.AtiCode);
				JSONObject json = JSONObject.fromObject(result);
				return json.toString();
			}		
			//根据用户获取用户
			User user = userService.findUser((String) session.getAttribute("username"));
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			String date = df.format(new Date());
			deviceCode.setActivateTime(date);
			deviceCode.setActivate(true);
			deviceCode.setActivateCode((String)session.getAttribute("activateCode"));
			deviceCode.setDeviceID(user.getUserID());
			deviceService.updateCode(deviceCode);
			
			//更新设备的同时更新设备码库
			UniCode nui = new UniCode();
			nui.setDid_uin(user.getUserID());
			nui.setCode(deviceCode.getUniqueID());
			System.out.println(nui);
			deviceService.updateUni(nui);
			
			session.setAttribute("user", user);
		}
		result.setKey("success");
		result.setMessage(result.Activate);
		JSONObject json = JSONObject.fromObject(result);
		return json.toString();
	}
	
}
