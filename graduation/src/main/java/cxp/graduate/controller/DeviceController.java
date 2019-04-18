package cxp.graduate.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cxp.graduate.pojo.Code;
import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.Order;
import cxp.graduate.pojo.Rows;
import cxp.graduate.pojo.User;
import cxp.graduate.service.DeviceService;
import cxp.graduate.service.UserService;
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
	@Autowired
	private UserService userService;
	
	UserResultUtils result = new UserResultUtils();
	
	@RequestMapping(value="device",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String device(@RequestBody Device d,HttpSession session) {
		User user = (User) session.getAttribute("user");
		//查询是否存在该设备
		boolean exitCode = deviceService.findDefaultCode(d.getD_code());
		if(!exitCode) {
			result.setKey("success");
			result.setMessage(result.UniCodeMsg1);
			JSONObject json = JSONObject.fromObject(result);
			return json.toString();
		}
		//查询设备是否被使用
		if( deviceService.findDeviceCode(d.getD_code()) != null) {
			result.setKey("success");
			result.setMessage(result.UniCodeMsg2);
			JSONObject json = JSONObject.fromObject(result);
			return json.toString();
		}
		//更新设备信息
		Device device = new Device();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		device.setD_code(d.getD_code());
		device.setD_activattime(date);
		device.setUid_did(user.getU_id());
		deviceService.saveDevice(device);
			
		user.setU_isact(true);
		userService.updateAct(user);
		
		int d_id = deviceService.findDeviceId(d.getD_code());
		System.out.println(d_id);
		
		//需同步更新code
		Code code = new Code();
		code.setCode(d.getD_code());
		code.setD_id(d_id);
		deviceService.updateCode(code);
		
		//需同步更新指令库
		Order order = new Order();
		order.setC_alarm(false);
		order.setC_relay(false);
		order.setC_flag(false);
		order.setCid_did(d_id);
		deviceService.saveOrder(order);
		
		result.setKey("success");
		result.setMessage(result.Activate);
		JSONObject json = JSONObject.fromObject(result);
		return json.toString();
	}
	
	@RequestMapping(value="devicemsg",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public String devicemsg(HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println(user.getU_id());
		//假如从session域中查询到的user不为null再进行查询	
		List<Device> list = new ArrayList<>();
		Rows rows = new Rows();
		List<Device> devices = deviceService.selectDeviceMsg(user.getU_id());
		for (int i = 0; i < devices.size(); i++) {
			list.add(devices.get(i));
		}
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
