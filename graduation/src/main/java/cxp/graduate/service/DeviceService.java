package cxp.graduate.service;

import java.util.List;

import cxp.graduate.pojo.Device;

/**
 * @ClassName：DeviceService
 * @Description: 设备的Service
 * @date: 2019-04-18
 */

public interface DeviceService {

	/**
	* @Title: findDefaultCode
	* @Description: 设备连接成功，根据设备码查询是否存在该用户
	* @param：String
	* @return：Device
	* @throws：
	 */
	public Device findDeviceByCode(String code);

	/**
	* @Title: findDeviceByUid
	* @Description: 根据用户id查询所有设备
	* @param：int
	* @return：List<Device>
	* @throws：
	 */
	public List<Device> findDeviceByUid(int u_id);

	/**
	* @Title: findDefaultCode
	* @Description: 激活时查询设备号
	* @param：String
	* @return：boolean
	* @throws：
	 */
	public String findDefaultCode(String code);

	/**
	* @Title: saveDevice
	* @Description: 插入设备的同时返回当前设备id
	* @param：User
	* @return：int
	* @throws：
	 */
	public int saveDevice(Device device);

	/**
	* @Title: updateSetAddr
	* @Description: 更新设备安装地址
	* @param：Device
	* @return：void
	* @throws：
	 */
	public void updateSetAddr(Device device);

	/**
	* @Title: findParlourOn
	* @Description: 首先根据时间排序，且状态在线
	* @param：int
	* @return：int
	* @throws：
	 */
	public int findParlourOn(Device device);

	/**
	* @Title: selectDeviceMsg
	* @Description: 查询设备，主要是形成表格显示
	* @param：
	* @return：
	* @throws：
	 */
	public List<Device> selectDeviceMsg(int u_id);
	
	/**
	* @Title: findParlourOn
	* @Description: 首先根据时间排序，且状态在线
	* @param：int
	* @return：int
	* @throws：
	 */
	public int findBedRoomOn(Device device);

	public int findKitchenOn(Device device);

	
}
