package cxp.graduate.service;

import java.util.List;

import cxp.graduate.pojo.Code;
import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.Devices;
import cxp.graduate.pojo.Order;

/**
 * @ClassName：DeviceService
 * @Description: 设备的Service
 * @date:
 */

public interface DeviceService {
	
	/**
	 * 
	* @Title: findDefaultCode
	* @Description: 设备连接网络之后查询编码是否正确
	* @param：String
	* @return：boolean
	* @throws：
	 */
	public boolean findDefaultCode(String code);
	
	/**
	* @Title: findDeviceId
	* @Description: 根据出厂的唯一编码获取id,不存在返回0
	* @param：String
	* @return：int
	* @throws：
	 */
	public int findDeviceId(String code);
	
	/**
	* @Title: selectUserDevice
	* @Description: 查询返回用户的所有设备
	* @param：int
	* @return：List
	* @throws：
	 */
	public Devices selectUserDevice(int uid_did);

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
	* @return：String
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
	* @Title: selectDeviceMsg
	* @Description: 查询设备，主要是形成表格显示
	* @param：
	* @return：
	* @throws：
	 */
	public List<Device> selectDeviceMsg(int u_id);

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
