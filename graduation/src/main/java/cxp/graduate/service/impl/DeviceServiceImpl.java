package cxp.graduate.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cxp.graduate.mapper.DeviceMapper;
import cxp.graduate.pojo.Code;
import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.Devices;
import cxp.graduate.pojo.Order;
import cxp.graduate.service.DeviceService;

/**
 * @ClassName：DeviceServiceImpl
 * @Description: 设备的Service实现
 * @date:
 */
@Service("deviceService")
public class DeviceServiceImpl implements DeviceService{

	@Autowired
	private DeviceMapper deviceMapper;
	
	@Override
	public boolean findDefaultCode(String code) {
		// TODO Auto-generated method stub
		if(deviceMapper.findDefaultCode(code) != null) {
			return true;
		}
		return false;
	}

	@Override
	public int findDeviceId(String code) {
		// TODO Auto-generated method stub
		if(deviceMapper.findDevice(code) != null) {
			return deviceMapper.findDeviceId(code);
		}
		return 0;
	}

	@Override
	public Devices selectUserDevice(int uid_did) {
		// TODO Auto-generated method stub	 
		List<Device> list = deviceMapper.selectUserDevice(uid_did);
		//获取用户总设备数
		int devicenum = list.size();
		//各个位置安装数
		Devices devices = new Devices();
		int parlour = 0,bedroom = 0,kitchen = 0;
		List parlourList = new ArrayList<>();
		List bedroomList = new ArrayList<>();
		List kitchenList = new ArrayList<>();
		List deviceIdList = new ArrayList<>();
		for(int i = 0;i < devicenum;i++) {
			if(list.get(i).getD_setaddr() != null) {
				if(list.get(i).getD_setaddr().equals("客厅")) {
					parlour++;
					parlourList.add(list.get(i).getD_id());
				}else if(list.get(i).getD_setaddr().equals("卧室")) {
					bedroom++;
					bedroomList.add(list.get(i).getD_id());
				}else if(list.get(i).getD_setaddr().equals("厨房")) {
					kitchen++;
					kitchenList.add(list.get(i).getD_id());
				}
			}	
			deviceIdList.add(list.get(i).getD_id());
		}
		devices.setDevices(devicenum);
		devices.setParlour(parlour);
		devices.setBedroom(bedroom);
		devices.setKitchen(kitchen);
		devices.setParlourId(parlourList);
		devices.setBedroomId(bedroomList);
		devices.setKitchenId(kitchenList);
		devices.setDeviceId(deviceIdList);
		return devices;
	}

	@Override
	public Device findDeviceCode(String d_code) {
		// TODO Auto-generated method stub
		return deviceMapper.findDeviceCode(d_code);
	}

	@Override
	public int saveDevice(Device device) {
		// TODO Auto-generated method stub
		return deviceMapper.saveDevice(device);
	}

	@Override
	public String findDeviceSetAddr(int d_id) {
		// TODO Auto-generated method stub
		return deviceMapper.findDeviceSetAddr(d_id);
	}

	@Override
	public void updateSetAddr(Device device) {
		// TODO Auto-generated method stub
		deviceMapper.updateSetAddr(device);
	}

	@Override
	public int findParlourOn(Device device) {
		// TODO Auto-generated method stub
		return deviceMapper.findParlourOn(device);
	}

	@Override
	public List<Device> selectDeviceMsg(int u_id) {
		// TODO Auto-generated method stub
		return deviceMapper.selectById(u_id);
	}

	@Override
	public void updateCode(Code code) {
		// TODO Auto-generated method stub
		deviceMapper.updateCode(code);
	}

	@Override
	public void saveOrder(Order order) {
		// TODO Auto-generated method stub
		deviceMapper.saveOrder(order);
	}
	
}
