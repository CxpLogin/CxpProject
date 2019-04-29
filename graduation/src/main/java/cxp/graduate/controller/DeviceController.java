package cxp.graduate.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import cxp.graduate.pojo.DidTime;
import cxp.graduate.pojo.Directive;
import cxp.graduate.pojo.Page;
import cxp.graduate.pojo.Rows;
import cxp.graduate.pojo.Sensor;
import cxp.graduate.pojo.SensorData;
import cxp.graduate.pojo.User;
import cxp.graduate.service.DeviceService;
import cxp.graduate.service.OrderService;
import cxp.graduate.service.SensorService;
import cxp.graduate.service.UserService;
import cxp.graduate.utils.JsonUtils;
import cxp.graduate.utils.UserResultUtils;
import net.sf.json.JSONArray;
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
	@Autowired
	private SensorService sensorService;
	
	@Autowired
	private OrderService orderService;
	
	UserResultUtils result = new UserResultUtils();
	
	@RequestMapping(value="device",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String device(@RequestBody Device d,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null && user.isU_isact() && (user.getU_email() ==null)) {
			result.setKey("success");
			result.setMessage(result.LoginOut);
			JSONObject json = JSONObject.fromObject(result);
			return json.toString();
		}
		//查询是否存在该设备
		String exitCode = deviceService.findDefaultCode(d.getD_code());
		System.out.println(exitCode);
		if(exitCode == null) {
			result.setKey("success");
			result.setMessage(result.UniCodeMsg1);
			JSONObject json = JSONObject.fromObject(result);
			return json.toString();
		}
		//查询设备是否被使用
		if( deviceService.findDeviceByCode(d.getD_code()) != null) {
			result.setKey("success");
			result.setMessage(result.UniCodeMsg2);
			JSONObject json = JSONObject.fromObject(result);
			return json.toString();
		}
		//更新设备信息
		//首先根据用户id将激活状态更新
		Device device = new Device();
		user.setU_isact(true);
		userService.updateActDevice(user);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		device.setD_code(d.getD_code());
		device.setD_activattime(date);
		device.setUid_did(user.getU_id());
		int did = deviceService.saveDevice(device);
		
		result.setKey("success");
		result.setMessage(result.Activate);
		JSONObject json = JSONObject.fromObject(result);
		return json.toString();
	}
	
	@RequestMapping(value="devicemsg",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public String devicemsg(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null && user.isU_isact() && (user.getU_email() ==null)) {
			result.setKey("success");
			result.setMessage(result.LoginOut);
			JSONObject json = JSONObject.fromObject(result);
			return json.toString();
		}
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
		ju.setTotal(1);
		ju.setRows(rows);
		JSONObject json = JSONObject.fromObject(ju);
		return json.toString();
	}
	
	@RequestMapping(value="Brelay",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String Brelay(HttpServletRequest request,HttpSession session) {
		String relayValue = request.getParameter("relay");
		int did_oid = (int) session.getAttribute("bedroomid");
		if(relayValue.equals("ON")) {
			Directive directive = new Directive();
			directive.setC_relay(true);
			directive.setC_flag(true);
			directive.setDid_oid(did_oid);
			orderService.updataDirectiveByRelay(directive);
		}else if(relayValue.equals("OFF")) {
			Directive directive = new Directive();
			directive.setC_relay(false);
			directive.setC_flag(true);
			directive.setDid_oid(did_oid);
			orderService.updataDirectiveByRelay(directive);
		}
		return null;		
	}
	
	@RequestMapping(value="Balarm",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String Balarm(HttpServletRequest request,HttpSession session) {
		String relayValue = request.getParameter("alarm");
		int did_oid = (int) session.getAttribute("bedroomid");
		if(relayValue.equals("ON")) {
			Directive directive = new Directive();
			directive.setC_alarm(true);
			directive.setC_flag(true);
			directive.setDid_oid(did_oid);
			orderService.updataDirectiveByAlarm(directive);
		}else if(relayValue.equals("OFF")) {
			Directive directive = new Directive();
			directive.setC_alarm(false);
			directive.setC_flag(true);
			directive.setDid_oid(did_oid);
			orderService.updataDirectiveByAlarm(directive);
		}
		return null;		
	}
	
	@RequestMapping(value="Krelay",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String Krelay(HttpServletRequest request,HttpSession session) {
		String relayValue = request.getParameter("relay");
		int did_oid = (int) session.getAttribute("kitchenid");
		if(relayValue.equals("ON")) {
			Directive directive = new Directive();
			directive.setC_relay(true);
			directive.setC_flag(true);
			directive.setDid_oid(did_oid);
			orderService.updataDirectiveByRelay(directive);
		}else if(relayValue.equals("OFF")) {
			Directive directive = new Directive();
			directive.setC_relay(false);
			directive.setC_flag(true);
			directive.setDid_oid(did_oid);
			orderService.updataDirectiveByRelay(directive);
		}
		return null;		
	}
	
	@RequestMapping(value="Kalarm",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String Kalarm(HttpServletRequest request,HttpSession session) {
		String relayValue = request.getParameter("alarm");
		int did_oid = (int) session.getAttribute("kitchenid");
		if(relayValue.equals("ON")) {
			Directive directive = new Directive();
			directive.setC_alarm(true);
			directive.setC_flag(true);
			directive.setDid_oid(did_oid);
			orderService.updataDirectiveByAlarm(directive);
		}else if(relayValue.equals("OFF")) {
			Directive directive = new Directive();
			directive.setC_alarm(false);
			directive.setC_flag(true);
			directive.setDid_oid(did_oid);
			orderService.updataDirectiveByAlarm(directive);
		}
		return null;		
	}
	
	@RequestMapping(value="Prelay",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String Prelay(HttpServletRequest request,HttpSession session) {
		String relayValue = request.getParameter("relay");
		int did_oid = (int) session.getAttribute("parlourid");
		if(relayValue.equals("ON")) {
			Directive directive = new Directive();
			directive.setC_relay(true);
			directive.setC_flag(true);
			directive.setDid_oid(did_oid);
			orderService.updataDirectiveByRelay(directive);
		}else if(relayValue.equals("OFF")) {
			Directive directive = new Directive();
			directive.setC_relay(false);
			directive.setC_flag(true);
			directive.setDid_oid(did_oid);
			orderService.updataDirectiveByRelay(directive);
		}
		return null;		
	}
	
	@RequestMapping(value="Palarm",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String Palarm(HttpServletRequest request,HttpSession session) {
		String relayValue = request.getParameter("alarm");
		int did_oid = (int) session.getAttribute("parlourid");
		if(relayValue.equals("ON")) {
			Directive directive = new Directive();
			directive.setC_alarm(true);
			directive.setC_flag(true);
			directive.setDid_oid(did_oid);
			orderService.updataDirectiveByAlarm(directive);
		}else if(relayValue.equals("OFF")) {
			Directive directive = new Directive();
			directive.setC_alarm(false);
			directive.setC_flag(true);
			directive.setDid_oid(did_oid);
			orderService.updataDirectiveByAlarm(directive);
		}
		return null;		
	}
	
	
	@RequestMapping(value="devices",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String devices(HttpServletRequest request,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null && user.isU_isact() && (user.getU_email() ==null)) {
			result.setKey("success");
			result.setMessage(result.LoginOut);
			JSONObject json = JSONObject.fromObject(result);
			return json.toString();
		}
		List<Device> devices = deviceService.findDeviceByUid(user.getU_id());
		List<Object> deviceId = new ArrayList<>();
		for (int i = 0; i < devices.size(); i++) {
			deviceId.add(devices.get(i).getD_id());
		}
		JSONArray jsonArray = JSONArray.fromObject(deviceId);
		return jsonArray.toString();
	}
}
