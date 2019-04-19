package cxp.graduate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cxp.graduate.mapper.DeviceMapper;
import cxp.graduate.mapper.OrderMapper;
import cxp.graduate.pojo.Code;
import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.Directive;
import cxp.graduate.pojo.User;
import cxp.graduate.service.DeviceService;

/**
 * @ClassName：DeviceServiceImpl
 * @Description: 设备的Service实现
 * @date: 2019-04-18
 */
@Service("deviceService")
public class DeviceServiceImpl implements DeviceService{

	@Autowired
	private DeviceMapper deviceMapper;
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public Device findDeviceByCode(String code) {
		// TODO Auto-generated method stub
		return deviceMapper.findDeviceByCode(code);
	}

	@Override
	public List<Device> findDeviceByUid(int u_id) {
		// TODO Auto-generated method stub
		return deviceMapper.findDeviceByUid(u_id);
	}

	@Override
	public String findDefaultCode(String code) {
		// TODO Auto-generated method stub
		return deviceMapper.findDefaultCode(code);
	}

	@Override
	public int saveDevice(Device device) {
		// TODO Auto-generated method stub
		//获取自增主键ID
		if(deviceMapper.saveDevice(device) > 0) {
			Device getDevice = deviceMapper.findDeviceByCode(device.getD_code());
			//根据设备设置指令库
			Directive directive = new Directive();
			directive.setC_alarm(true);
			directive.setC_relay(false);
			directive.setC_flag(false);
			directive.setDid_oid(getDevice.getD_id());
			orderMapper.insertDirective(directive);
			
			//根据设备更新编码库
			Code code = new Code();
			code.setCode(device.getD_code());
			code.setDid_cid(device.getD_id());
			deviceMapper.updateFactoryCode(code);
			return getDevice.getD_id();
		}else {
			return 0;
		}
	}

	@Override
	public void updateSetAddr(Device device) {
		// TODO Auto-generated method stub
		deviceMapper.updateSetAddr(device);
	}

	@Override
	public int findParlourOn(Device device) {
		// TODO Auto-generated method stub
		if(deviceMapper.findParlourOn(device) == null) {
			return 0;
		}
		return deviceMapper.findParlourOn(device);
	}

	@Override
	public List<Device> selectDeviceMsg(int u_id) {
		// TODO Auto-generated method stub
		return deviceMapper.selectById(u_id);
	}

	@Override
	public int findBedRoomOn(Device device) {
		// TODO Auto-generated method stub
		if(deviceMapper.findBedRoomOn(device) == null) {
			return 0;
		}
		return deviceMapper.findBedRoomOn(device);
	}

	@Override
	public int findKitchenOn(Device device) {
		// TODO Auto-generated method stub
		if(deviceMapper.findKitchenOn(device) == null) {
			return 0;
		}
		return deviceMapper.findKitchenOn(device);
	}
	
}
