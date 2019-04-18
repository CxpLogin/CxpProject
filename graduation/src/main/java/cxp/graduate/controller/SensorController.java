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
import cxp.graduate.pojo.Devices;
import cxp.graduate.pojo.MapBean;
import cxp.graduate.pojo.Sensor;
import cxp.graduate.pojo.User;
import cxp.graduate.service.DeviceService;
import cxp.graduate.service.SensorService;
import cxp.graduate.utils.BaiduMapUtils;
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
	@Autowired
	private DeviceService deviceService;
	
	UserResultUtils result = new UserResultUtils();
	
	@RequestMapping(value="sensor",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String sensor(HttpSession session) throws MalformedURLException {	
		//根据用户id和要查询的安装位置的传感器查询设备id
		User user = (User) session.getAttribute("user");
		//根据用户的id获取设备数
		Devices devices = deviceService.selectUserDevice(user.getU_id());
		//Devices [devices=2, parlour=1, bedroom=1, kitchen=0, parlourId=[1], bedroomId=[2], kitchenId=[]]
		//异步更新设备信息,每点击一次则查询一次且更新一次
		//1、首先获取客厅的状态
		System.out.println(devices);
		MapBean mapbean = new MapBean();
		BaiduMapUtils baidu = new BaiduMapUtils();
		Device device = new Device();
		if(devices.getParlour() == 0) {
			for (int i = 0; i < devices.getDevices(); i++) {
				if(deviceService.findDeviceSetAddr((int) devices.getDeviceId().get(i)) == null) {
					List<Sensor> list = sensorService.selectSensorSetAddr((int) devices.getDeviceId().get(i));
					mapbean.setSetaddr(list.get(i).getSetaddr());
					mapbean.setGpsaddr(list.get(i).getGpsaddr());
					
					device.setD_id((int) devices.getDeviceId().get(i));
					if(mapbean.getSetaddr().equals("parlour")) {
						device.setD_setaddr("客厅");
					}
					device.setD_physics(mapbean.getGpsaddr());
					String jinweidu = mapbean.getGpsaddr();
					String[]  strs=jinweidu.split("-");
					String jingdu = strs[0];
					String weidu = strs[1];
					device.setD_instaladdr(baidu.getPosition(jingdu,weidu));
					deviceService.updateSetAddr(device);
				}
			}		
		}
		device.setD_setaddr("客厅");
		device.setUid_did(user.getU_id());
		device.setD_state(true);
		//根据设备查询传感器			
		return sensorService.selectSensorData(deviceService.findParlourOn(device)); 
	}
	
}
