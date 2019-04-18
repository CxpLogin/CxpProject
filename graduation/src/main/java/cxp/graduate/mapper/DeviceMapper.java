package cxp.graduate.mapper;

import java.util.List;

import cxp.graduate.pojo.Code;
import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.Order;

public interface DeviceMapper {	
	
	//思路：直接查询device_code是否存在出厂编码
	/**
	* @Title: findDefaultCode
	* @Description: 查询出厂码 
	* @param：String
	* @return：String
	* @throws：
	 */
 	public String findDefaultCode(String code);
 	
 	/**
 	* @Title: findDevice
 	* @Description: 根据出厂编码获取整个设备的信息
 	* @param：String
 	* @return：Device
 	* @throws：
 	 */
 	public Device findDevice(String code);
 	
 	/**
	* @Title: findDeviceId
	* @Description: 根据出厂编码获取设备id
	* @param：String
	* @return：int 
	* @throws：
	 */
 	public int findDeviceId(String code);
 	
 	/**
 	* @Title: selectUserDevice
 	* @Description: 根据用户的id查询当前设备
 	* @param：
 	* @return：
 	* @throws：
 	 */
 	public List<Device> selectUserDevice(int uid_did);
 	
 	/**
 	* @Title: findDeviceSetAddrNum
 	* @Description: 查询用户安装位置的个数
 	* @param：Device
 	* @return：
 	* @throws：
 	 */
 	public int findDeviceSetAddrNum(Device device);

 	/**
	* @Title: findDeviceCode
	* @Description: 查询设备是否被使用
	* @param：d_code
	* @return：
	* @throws：
	 */
	public Device findDeviceCode(String d_code);
	
	/**
	* @Title: saveDevice
	* @Description: 插入一条设备
	* @param：Device
	* @return：void
	* @throws：
	 */
	public int saveDevice(Device device);

	/**
	* @Title: findDeviceSetAddr
	* @Description: 根据d_did查询那个客厅为空
	* @param：int
	* @return：void
	* @throws：
	 */
	public String findDeviceSetAddr(int d_id);

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
	 * 
	* @Title: selectById
	* @Description: 根据用户id查询设备
	* @param：
	* @return：
	* @throws：
	 */
	public List<Device> selectById(int uid_did);

	/**
	* @Title: updateCode
	* @Description:更新设备库
	* @param：int
	* @return：void
	* @throws：
	 */
	public void updateCode(Code code);

	public void saveOrder(Order order);
	
}
