package cxp.graduate.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cxp.graduate.pojo.User;
import cxp.graduate.service.SensorService;
import cxp.graduate.utils.UserResultUtils;
import net.sf.json.JSONObject;

/**
 * @ClassName：SensorController
 * @Description: 处理传感器数据
 * @date: 2019-03-11 V1.1
 */
@Controller
@RequestMapping("/user")
public class SensorController {
	
	@Autowired
	private SensorService sensorService;
	
	UserResultUtils result = new UserResultUtils();
	
	@RequestMapping(value="sensor",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String sensor(HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		//请求获取烟雾传感器数据
		//System.out.println("成功请求数据");
		String str = sensorService.selectById(user.getUserID());
		return str;
	}
	
}
