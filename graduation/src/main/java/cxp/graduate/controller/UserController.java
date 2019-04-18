package cxp.graduate.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cxp.graduate.pojo.LoginUser;
import cxp.graduate.pojo.User;
import cxp.graduate.service.DeviceService;
import cxp.graduate.service.UserService;
import cxp.graduate.utils.CodeFactory;
import cxp.graduate.utils.EmailValidateCode;
import cxp.graduate.utils.RandomValidateCode;
import cxp.graduate.utils.UserResultUtils;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController {
	/**
	 * @ClassName：UserController
	 * @Description: 用户登录、注册处理模块
	 * @date: 2019-03-07 v1.1
	 */
	@Autowired
	private UserService userService;
	@Autowired
	private DeviceService deviceService;
	
	UserResultUtils result = new UserResultUtils();
	
	/**
	 * 
	* @Title: check
	* @Description: 检测用户登录的情况，若登录了自动跳转到主页
	* @param：
	* @return：
	* @throws：
	 */
	@RequestMapping(value="check",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String check(HttpSession session) {
		User user = (User) session.getAttribute("user");
		//查看session域中没有user
		if(user != null && user.isU_isact() && (user.getU_email() !=null)) {
			result.setKey("success");
			result.setMessage(result.LoginIn);
			JSONObject json = JSONObject.fromObject(result);
			return json.toString();
		}
		result.setKey("success");
		result.setMessage(result.LoginOut);
		JSONObject json = JSONObject.fromObject(result);
		return json.toString();
	}
		
	/**
	* @Title: getVerify
	* @Description:验证码模块刷新
	* @param：
	* @return：
	* @throws：
	 */
	@RequestMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	//用户登录
	@RequestMapping(value="login",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String login(@RequestBody LoginUser lu,HttpSession session) {
		//首先判断验证码是否正确
		String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
		if(!(lu.getCode().equals(random))) {
        	result.setKey("success");
    		result.setMessage(result.CodeError);
    		JSONObject json = JSONObject.fromObject(result);
    		return json.toString();
        }
		
		//用户登录逻辑
		User user = new User();
		user.setU_name(lu.getUserName());
		user.setU_pwd(lu.getUserPwd());
		User findUser = userService.findUser(user);
		if (findUser == null) {
			result.setKey("success");
			result.setMessage(result.LoginError);
			JSONObject json = JSONObject.fromObject(result);
			return json.toString();
		}
		session.setAttribute("user", findUser);//假如session
		
		//用户是否激活邮箱、是否激活设备 
		if(findUser.getU_emailcode() == null) {
			
			//生成加密文
			CodeFactory codeFactory = new CodeFactory();
			String  code = codeFactory.getCode();//生成随机字符串
			session.setAttribute("activateCode", code);
			String DeCode = CodeFactory.encrypt(code);//生成加密文
			System.out.println( "生成的随机code：" + DeCode);

			//以当前用户的邮箱进行邮件的发送
			EmailValidateCode evc = new EmailValidateCode();
			evc.sendEmail(findUser.getU_email(), DeCode);	
			result.setKey("success");
			result.setMessage("请激活邮箱");
			JSONObject json = JSONObject.fromObject(result);
			return json.toString();
		}
		
		if(!(findUser.isU_isact())) {
			System.out.println(findUser);
			result.setKey("success");
			result.setMessage(result.DeviceOFF);
			JSONObject json = JSONObject.fromObject(result);
			return json.toString();
		}
		
		result.setKey("success");
		result.setMessage(result.LoginSuccess);
		JSONObject json = JSONObject.fromObject(result);
		return json.toString();
    }
	
	//用户注册
	@RequestMapping(value="regist",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String regist(@RequestBody User u) {
		//1、首先判断用户名和邮箱是否被使用过
		String existUser = userService.findUserByName(u.getU_name());
		if( existUser.equals(result.NameExisted)) {
			result.setKey("success");
			result.setMessage(result.NameExisted);
			JSONObject json = JSONObject.fromObject(result);
			return json.toString();
		}
		//2、判断邮箱是否存在
		if(!(userService.findUserEmail(u.getU_email()))) {
			result.setKey("success");
			result.setMessage(result.EmailExist);
			JSONObject json = JSONObject.fromObject(result);
			return json.toString();
		}
		//3、填入用户名、密码和邮箱
		CodeFactory codeFactory = new CodeFactory();//加密密码
		User user = new User();
		user.setU_name(u.getU_name());
		user.setU_pwd(codeFactory.encrypt(u.getU_pwd()));
		user.setU_email(u.getU_email());
		userService.saveUser(user);
		
		result.setKey("success");
		result.setMessage(result.RegistSuccess);
		JSONObject json = JSONObject.fromObject(result);
		return json.toString();
	}
	
	/**
	* 
	* @Title: forgetpwd
	* @Description:验证码模块刷新
	* @param：
	* @return：
	* @throws：
	 */
	@RequestMapping(value="forgetpwd",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String forgetpwd(HttpServletRequest request) {
		EmailValidateCode evc = new EmailValidateCode();
		String email = request.getParameter("email");
		evc.sendEmail(email, userService.findUserPwd(email));	
		result.setKey("success");
		result.setMessage(result.SendEmail);
		JSONObject json = JSONObject.fromObject(result);
		return json.toString();
    }
	
	//用户注销
	@RequestMapping(value="logout",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String logout(HttpSession session) {
		//假如存在用户则注销,注销后定向到登录
		User user = (User) session.getAttribute("user");
		if(user != null) {
			session.removeAttribute("user");
			result.setKey("success");
			result.setMessage(result.LoginOut);
			JSONObject json = JSONObject.fromObject(result);
			return json.toString();
		}
		//不存在用户则提示并定向到登录
		result.setKey("success");
		result.setMessage(result.LoginOut);
		JSONObject json = JSONObject.fromObject(result);
		return json.toString();
	}
	
	//显示用户名
	@RequestMapping(value="welcome",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String welcome(HttpSession session) {
		User user = (User) session.getAttribute("user");
		result.setKey("success");
		result.setMessage(user.getU_name());
		System.out.println(user.getU_name());
		JSONObject json = JSONObject.fromObject(result);
		return json.toString();
	}

}
