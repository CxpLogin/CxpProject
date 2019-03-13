package com.cxp.junit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cxp.graduate.mapper.DeviceMapper;
import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.Rows;
import cxp.graduate.pojo.UniCode;
import cxp.graduate.service.DeviceService;
import cxp.graduate.utils.JsonUtils;
import net.sf.json.JSONObject;


@RunWith(SpringJUnit4ClassRunner.class)//帮我们创建容器
@ContextConfiguration("classpath:applicationContext.xml")//指定创建容器时使用哪个配置文件
public class DeviceJuint {                        
	
	@Autowired
	private DeviceService deviceService;
	@Autowired
	private DeviceMapper deviceMapper;
	
	//测试更新
	@Test
	public void demo1() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		Device device = new Device();
		device.setActivateTime(date);
		device.setActivate(false);
		device.setActivateCode("152144144154138152134146156160140140134140134132");
		device.setUniqueID("KIOGHT");
		deviceService.updateCode(device);
	}
	
	/*查询用户设备*/
	@Test
	public void demo2() {
		Device device = deviceMapper.selectById(1);
		System.out.println(device);
	}
	
	/*将数据转成layui需要的格式*/
	@Test
	public void demo3() {
		List<Device> list = new ArrayList<>();
		Rows rows = new Rows();
		list.add(deviceService.selectDeviceMsg(1));
		rows.setItem(list);
		JsonUtils ju = new JsonUtils();
		ju.setStatus(200);
		ju.setMessage("hello");
		ju.setTotal(1L);
		ju.setRows(rows);
		JSONObject json = JSONObject.fromObject(ju);
		System.out.println(json.toString());
	}
	
	/*将获取到的设备码与数据库进行对比*/
	@Test
	public void demo4() {
		String devStr = deviceService.compareCode("2WS9GF");
		System.out.println(devStr);
	}
}