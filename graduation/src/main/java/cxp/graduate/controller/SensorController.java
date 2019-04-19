package cxp.graduate.controller;

import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.Sensor;
import cxp.graduate.pojo.User;
import cxp.graduate.service.DeviceService;
import cxp.graduate.service.SensorService;
import cxp.graduate.utils.BaiduMapUtils;
import cxp.graduate.utils.UserResultUtils;

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
	@Autowired
	private DeviceService deviceService;
	
	UserResultUtils result = new UserResultUtils();
	
	@RequestMapping(value="parlour",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String parlour(HttpSession session) throws MalformedURLException {	
		//根据用户id和要查询的安装位置的传感器查询设备id
		User user = (User) session.getAttribute("user");
		List<Device> devices = deviceService.findDeviceByUid(user.getU_id());
		//List<Sensor> list = null ;list = sensorService.selectSensorSetAddr(devices.get(i).getD_id());
		//遍历所有id去获取传感器的的地址
		Device device = new Device();
		BaiduMapUtils baidu = new BaiduMapUtils();
		for (int i = 0; i < devices.size(); i++) {
			List<Sensor> list = sensorService.selectSensorSetAddr(devices.get(i).getD_id());
			
			if(list.get(i).getSetaddr().equals("parlour")) {
				String jinweidu = list.get(i).getGpsaddr();
				String[]  strs=jinweidu.split("-");
				String jingdu = strs[0];
				String weidu = strs[1];
				device.setD_id(devices.get(i).getD_id());
				device.setD_physics(jinweidu);
				device.setD_setaddr("客厅");		
				device.setD_state(true);
				device.setD_instaladdr(baidu.getPosition(jingdu,weidu));
				deviceService.updateSetAddr(device);
			}else if(list.get(i).getSetaddr().equals("bedroom")) {
				String jinweidu = list.get(i).getGpsaddr();
				String[]  strs=jinweidu.split("-");
				String jingdu = strs[0];
				String weidu = strs[1];
				device.setD_id(devices.get(i).getD_id());
				device.setD_physics(jinweidu);
				device.setD_setaddr("卧室");	
				device.setD_state(true);
				device.setD_instaladdr(baidu.getPosition(jingdu,weidu));
				deviceService.updateSetAddr(device);
			}else if(list.get(i).getSetaddr().equals("kitchen")) {
				String jinweidu = list.get(i).getGpsaddr();
				String[]  strs=jinweidu.split("-");
				String jingdu = strs[0];
				String weidu = strs[1];
				device.setD_id(devices.get(i).getD_id());
				device.setD_physics(jinweidu);
				device.setD_setaddr("厨房");	
				device.setD_state(true);
				device.setD_instaladdr(baidu.getPosition(jingdu,weidu));
				deviceService.updateSetAddr(device);
			}
			
		}
		//查询客厅、且注册时间排序且未状态为1
		System.out.println(device);	
		device.setD_setaddr("客厅");
		device.setD_state(true);
		device.setUid_did(user.getU_id());
		int d_id = deviceService.findParlourOn(device);	
		session.setAttribute("parlourid", d_id);
		return sensorService.selectSensorData(d_id);
	}
	
	@RequestMapping(value="bedroom",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String bedroom(HttpSession session) throws MalformedURLException {	
		//根据用户id和要查询的安装位置的传感器查询设备id
		User user = (User) session.getAttribute("user");
		List<Device> devices = deviceService.findDeviceByUid(user.getU_id());
		//List<Sensor> list = null ;list = sensorService.selectSensorSetAddr(devices.get(i).getD_id());
		//遍历所有id去获取传感器的的地址
		Device device = new Device();
		BaiduMapUtils baidu = new BaiduMapUtils();
		for (int i = 0; i < devices.size(); i++) {
			List<Sensor> list = sensorService.selectSensorSetAddr(devices.get(i).getD_id());
			
			if(list.get(i).getSetaddr().equals("parlour")) {
				String jinweidu = list.get(i).getGpsaddr();
				String[]  strs=jinweidu.split("-");
				String jingdu = strs[0];
				String weidu = strs[1];
				device.setD_id(devices.get(i).getD_id());
				device.setD_physics(jinweidu);
				device.setD_setaddr("客厅");		
				device.setD_state(true);
				device.setD_instaladdr(baidu.getPosition(jingdu,weidu));
				deviceService.updateSetAddr(device);
			}else if(list.get(i).getSetaddr().equals("bedroom")) {
				String jinweidu = list.get(i).getGpsaddr();
				String[]  strs=jinweidu.split("-");
				String jingdu = strs[0];
				String weidu = strs[1];
				device.setD_id(devices.get(i).getD_id());
				device.setD_physics(jinweidu);
				device.setD_setaddr("卧室");	
				device.setD_state(true);
				device.setD_instaladdr(baidu.getPosition(jingdu,weidu));
				deviceService.updateSetAddr(device);
			}else if(list.get(i).getSetaddr().equals("kitchen")) {
				String jinweidu = list.get(i).getGpsaddr();
				String[]  strs=jinweidu.split("-");
				String jingdu = strs[0];
				String weidu = strs[1];
				device.setD_id(devices.get(i).getD_id());
				device.setD_physics(jinweidu);
				device.setD_setaddr("厨房");	
				device.setD_state(true);
				device.setD_instaladdr(baidu.getPosition(jingdu,weidu));
				deviceService.updateSetAddr(device);
			}
			
		}
		//查询客厅、且注册时间排序且未状态为1
		System.out.println(device);	
		device.setD_setaddr("卧室");
		device.setD_state(true);
		device.setUid_did(user.getU_id());
		int d_id = deviceService.findBedRoomOn(device);
		session.setAttribute("bedroomid", d_id);
		return sensorService.selectSensorData(d_id);
	}
	
	@RequestMapping(value="kitchen",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String kitchen(HttpSession session) throws MalformedURLException {	
		//根据用户id和要查询的安装位置的传感器查询设备id
		User user = (User) session.getAttribute("user");
		List<Device> devices = deviceService.findDeviceByUid(user.getU_id());
		//List<Sensor> list = null ;list = sensorService.selectSensorSetAddr(devices.get(i).getD_id());
		//遍历所有id去获取传感器的的地址
		Device device = new Device();
		BaiduMapUtils baidu = new BaiduMapUtils();
		for (int i = 0; i < devices.size(); i++) {
			List<Sensor> list = sensorService.selectSensorSetAddr(devices.get(i).getD_id());
			
			if(list.get(i).getSetaddr().equals("parlour")) {
				String jinweidu = list.get(i).getGpsaddr();
				String[]  strs=jinweidu.split("-");
				String jingdu = strs[0];
				String weidu = strs[1];
				device.setD_id(devices.get(i).getD_id());
				device.setD_physics(jinweidu);
				device.setD_setaddr("客厅");		
				device.setD_state(true);
				device.setD_instaladdr(baidu.getPosition(jingdu,weidu));
				deviceService.updateSetAddr(device);
			}else if(list.get(i).getSetaddr().equals("bedroom")) {
				String jinweidu = list.get(i).getGpsaddr();
				String[]  strs=jinweidu.split("-");
				String jingdu = strs[0];
				String weidu = strs[1];
				device.setD_id(devices.get(i).getD_id());
				device.setD_physics(jinweidu);
				device.setD_setaddr("卧室");	
				device.setD_state(true);
				device.setD_instaladdr(baidu.getPosition(jingdu,weidu));
				deviceService.updateSetAddr(device);
			}else if(list.get(i).getSetaddr().equals("kitchen")) {
				String jinweidu = list.get(i).getGpsaddr();
				String[]  strs=jinweidu.split("-");
				String jingdu = strs[0];
				String weidu = strs[1];
				device.setD_id(devices.get(i).getD_id());
				device.setD_physics(jinweidu);
				device.setD_setaddr("厨房");	
				device.setD_state(true);
				device.setD_instaladdr(baidu.getPosition(jingdu,weidu));
				deviceService.updateSetAddr(device);
			}
			
		}
		//查询客厅、且注册时间排序且未状态为1
		System.out.println(device);	
		device.setD_setaddr("厨房");
		device.setD_state(true);
		device.setUid_did(user.getU_id());
		int d_id = deviceService.findKitchenOn(device);
		//将当前id放到session域
		session.setAttribute("kitchenid", d_id);
		return sensorService.selectSensorData(d_id);
	}
	
}
