package cxp.graduate.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cxp.graduate.pojo.Email;
import cxp.graduate.pojo.LoginFormBean;
import cxp.graduate.pojo.RegistFormBean;
import cxp.graduate.pojo.User;
import cxp.graduate.service.EmailService;
import cxp.graduate.service.UserService;
import cxp.graduate.utils.CodeFactory;
import cxp.graduate.utils.RandomValidateCode;
import cxp.graduate.utils.RegisterValidate;
import cxp.graduate.utils.UserResultUtils;
import net.sf.json.JSONObject;

/**
 * 
 * @ClassName:  UserController   
 * @Description:主要处理普通用户业务逻辑 
 * @date:   2018年11月23日 下午5:36:33
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
//	private static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	//用户登录
	@RequestMapping(value="login",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String login(@RequestBody LoginFormBean formInfo,HttpSession session) {
		UserResultUtils result = new UserResultUtils();
		
		//1、提前判断用户类型
		if(formInfo.getType().equals("admin")) {
			System.out.println("直接跳转到adminController");
		}else {
			System.out.println("用户为user");
			
			//2、判断验证码是否输入正确
	        String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
	        if(!(formInfo.getCode().equals(random))) {
	        	result.setKey("error");
	    		result.setMessage("验证码输入错误");
	    		JSONObject json = JSONObject.fromObject(result);
	    		return json.toString();
	        }else {
	        	//3、查询用户、检测邮箱是否激活
				User user = new User();
				user.setUserName(formInfo.getLoginName());
				user.setUserPwd(formInfo.getLoginPwd());
				User findUser = userService.findUser(user);
				if (findUser==null) {
					result.setKey("error");
					result.setMessage("用户名或密码不正确");
					JSONObject json = JSONObject.fromObject(result);
					return json.toString();
				}
			}
		}	
		result.setKey("success");
		result.setMessage("登录成功");
		JSONObject json = JSONObject.fromObject(result);
		return json.toString();
	}
	
	//用户登录
	@RequestMapping(value="regist",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String regist(@RequestBody RegistFormBean info) {
		UserResultUtils result = new UserResultUtils();
		//1、首先判断用户名是否被使用过
		User exitUser = userService.findUserByName(info.getRegistName());
		if( exitUser != null) {
			result.setKey("error");
			result.setMessage("用户名用户名已存在");
			JSONObject json = JSONObject.fromObject(result);
			return json.toString();
		}else {
			//2、判断邮箱是否存在
			Email exitEmail = emailService.findEmailName(info.getRegistEmail());
			if( exitEmail != null) {
				result.setKey("error");
				result.setMessage("邮箱已存在");
				JSONObject json = JSONObject.fromObject(result);
				return json.toString();
			}
			//3、邮箱不存在，优先插入邮箱
			CodeFactory codeFactory = new CodeFactory();
			String  code = codeFactory.getCode();
			RegisterValidate rv	= new RegisterValidate();
			System.out.println(CodeFactory.encrypt(code));
			rv.sendEmail(info.getRegistEmail(), CodeFactory.encrypt(code));
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			String date = df.format(new Date());
			Email email = new Email();
			email.setEmail(info.getRegistEmail());
			email.setCode(code);
			email.setDate(date);
			email.setState(false);
			emailService.insertEamil(email);
		}	
		//3、将名字和密码插入到user表中
		User user = new User();
		user.setUserName(info.getRegistName());
		user.setUserPwd(info.getRegistPwd());
		int id = userService.getUserId(user);
		//更新表
		emailService.updateEmailUid(id, info.getRegistEmail());
		result.setKey("success");
		result.setMessage("注册成功");
		JSONObject json = JSONObject.fromObject(result);
		return json.toString();
	}
	
	//验证码
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
}
