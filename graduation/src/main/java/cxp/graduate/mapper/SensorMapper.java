package cxp.graduate.mapper;

import java.util.List;

import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.Sensor;

public interface SensorMapper {	
	
	/**
	* @Title: selectCount
	* @Description: 以设备id查询数据（一般一个设备存10条数据）
	* @param：int
	* @return：int
	* @throws：
	 */
	public int selectSensorCount(int did_sid);
	
	/**
	* @Title: deleteFirstTime
	* @Description: 插入的同时删除时间最早的那一条数据
	* @param：int
	* @return：void
	* @throws：
	 */
	public void deleteFirstTime(int did_sid);
	
	/**
	* @Title: insertTime
	* @Description: 插入一条数据
	* @param：Sensor
	* @return：void
	* @throws：
	 */
	public void insertData(Sensor sensor);

	/**
	* @Title: findSensorSetAddr
	* @Description: 根据设备id查询传感器数据
	* @param：int
	* @return：Sensor
	* @throws：
	 */
	public List<Sensor> selectSensorSetAddr(int did_sid);

	/**
	* @Title: selectByDid
	* @Description: 根据设备的id查询传感器数据
	* @param：int
	* @return：List<Sensor>
	* @throws：
	 */
	public List<Sensor> selectByDid(int did_sid);
	
}
