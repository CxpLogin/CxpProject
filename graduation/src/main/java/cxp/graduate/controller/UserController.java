package cxp.graduate.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cxp.graduate.pojo.LoginFormBean;
import cxp.graduate.pojo.User;
import cxp.graduate.service.UserService;
import cxp.graduate.utils.RandomValidateCode;
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
	
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
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
	        System.out.println(random);
	        System.out.println(formInfo.getCode());
	        if(!(formInfo.getCode().equals(random))) {
	        	result.setKey("error");
	    		result.setMessage("验证码输入错误");
	    		JSONObject json = JSONObject.fromObject(result);
	    		return json.toString();
	        }else {
	        	//3、查询用户、检测邮箱是否激活
				User user = new User();
				user.setUserName(formInfo.getBaseName());
				user.setUserPwd(formInfo.getBasePwd());
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
	
	@RequestMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response){
		System.out.println("进来了");
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
