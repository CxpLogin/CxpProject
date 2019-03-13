package cxp.graduate.mapper;

import java.util.List;

import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.UniCode;

public interface DeviceMapper {	
	
	/**
	 * 
	* @Title: insertDevice
	* @Description: 同步更新device
	* @param：
	* @return：
	* @throws：
	 */
	public int insertDevice(int userid);
	
	/**
	 * 
	* @Title: selectById
	* @Description: 根据用户id查询设备
	* @param：
	* @return：
	* @throws：
	 */
	public Device selectById(int userid);
	
	/**
	 * 
	* @Title: updateCode
	* @Description: 根据userID将设备码和激活插入到数据库中
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
	* @Title: selectUniCode
	* @Description: 根据设备码查询是否在数据库中存在设备码
	* @param：
	* @return：
	* @throws：
	 */
	public UniCode findUniqueCode(String code);
}
