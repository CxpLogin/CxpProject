package cxp.graduate.service;

import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.UniCode;
import cxp.graduate.pojo.User;

public interface DeviceService {
	
	/**
	 * 
	* @Title: selectDeviceMsg
	* @Description: 查询设备，主要是形成表格显示
	* @param：
	* @return：
	* @throws：
	 */
	public Device selectDeviceMsg(int userID);
	
	/**
	 * 
	* @Title: insertDevice
	* @Description: 获取用户id后更新设备表
	* @param：
	* @return：
	* @throws：
	 */
	public void insertDevice(int userID);
	
	/**
	 * 
	* @Title: updateCode
	* @Description: 更新激活码等信息
	* @param：
	* @return：
	* @throws：
	 */
	public int updateCode(Device device);
	
	/**
	 * 
	* @Title: updateUni
	* @Description: 更新设备码库
	* @param：
	* @return：
	* @throws：
	 */
	public int updateUni(UniCode uni);
	
	/**
	 * 
	* @Title: compareCode
	* @Description: 与数据库的设备码匹配
	* @param：
	* @return：
	* @throws：
	 */
	public String compareCode(String uniqueCode);
	
}
