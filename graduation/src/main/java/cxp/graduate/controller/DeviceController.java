package cxp.graduate.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.Rows;
import cxp.graduate.pojo.User;
import cxp.graduate.service.DeviceService;
import cxp.graduate.utils.JsonUtils;
import cxp.graduate.utils.UserResultUtils;
import net.sf.json.JSONObject;

/**
 * @ClassName：SensorController
 * @Description: 处理传感器数据
 * @date: 2019-03-11 V1.1
 */
@Controller
@RequestMapping("/user")
public class DeviceController {
	
	@Autowired
	private DeviceService deviceService;
	
	UserResultUtils result = new UserResultUtils();
	
	@RequestMapping(value="device",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public String device(HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		//假如从session域中查询到的user不为null再进行查询	
		List<Device> list = new ArrayList<>();
		Rows rows = new Rows();
		list.add(deviceService.selectDeviceMsg(user.getUserID()));
		rows.setItem(list);
		JsonUtils ju = new JsonUtils();
		ju.setStatus(200);
		ju.setMessage("hello");
		ju.setTotal(1L);
		ju.setRows(rows);
		JSONObject json = JSONObject.fromObject(ju);
		return json.toString();
	}
	
}
