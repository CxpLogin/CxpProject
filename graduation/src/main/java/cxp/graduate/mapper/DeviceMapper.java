package cxp.graduate.mapper;

import java.util.List;

import cxp.graduate.pojo.Code;
import cxp.graduate.pojo.Device;

public interface DeviceMapper {

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
	* @Title: updateFactoryCode
	* @Description: 更新出厂编码库
	* @param：Code
	* @return：void
	* @throws：
	 */
	public void updateFactoryCode(Code code);

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
	public Integer findParlourOn(Device device);

	/**
	 * 
	* @Title: selectById
	* @Description: 设备合计
	* @param：List<Device>
	* @return：
	* @throws：
	 */
	public List<Device> selectById(int u_id);
	
	/**
	* @Title: findParlourOn
	* @Description: 首先根据时间排序，且状态在线
	* @param：int
	* @return：int
	* @throws：
	 */
	public Integer findBedRoomOn(Device device);

	public Integer findKitchenOn(Device device);
}
