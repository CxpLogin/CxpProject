package cxp.graduate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cxp.graduate.mapper.DeviceMapper;
import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.UniCode;
import cxp.graduate.service.DeviceService;
import cxp.graduate.utils.UserResultUtils;
import net.sf.json.JSONArray;

@Service("deviceService")
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceMapper deviceMapper;

	UserResultUtils result = new UserResultUtils();
	
	@Override
	public void insertDevice(int userID) {
		// TODO Auto-generated method stub
		deviceMapper.insertDevice(userID);
	}

	@Override
	public int updateCode(Device device) {
		// TODO Auto-generated method stub
		return deviceMapper.updateCode(device);
	}

	@Override
	public Device selectDeviceMsg(int userID) {
		// TODO Auto-generated method stub
		return deviceMapper.selectById(userID);
	}

	@Override
	public String compareCode(String uniqueCode) {
		// TODO Auto-generated method stub
		UniCode uni = deviceMapper.findUniqueCode(uniqueCode);
		if(uni == null) {
			return result.UniCodeMsg1;
		}
		//获取该设备码与设备所连接的did_uin
		if(uni.getDid_uin() == 0) {
			return result.UniCodeMsg3;
		}else {
			if(deviceMapper.selectById(uni.getDid_uin()) != null) {
				return result.UniCodeMsg2;
			}
		}
		
		return result.UniCodeMsg3;
	}

	@Override
	public int updateUni(UniCode uni) {
		// TODO Auto-generated method stub
		return deviceMapper.updateUni(uni);
	}

	

}
