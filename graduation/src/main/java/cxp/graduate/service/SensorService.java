package cxp.graduate.service;

import java.util.List;

import cxp.graduate.pojo.Sensor;

/**
 * @ClassName：SensorService
 * @Description: 传感器的Service
 * @date:
 */

public interface SensorService {

	/**
	* @Title: insertSensorData
	* @Description: 向数据库插入传感器数据
	* @param：Sensor
	* @return：void
	* @throws：
	 */
	public void insertSensorData(Sensor sensor);

	/**
	* @Title: selectSensorSetAddr
	* @Description: 获取传感器的地址
	* @param：int
	* @return：void
	* @throws：
	 */
	public List<Sensor> selectSensorSetAddr(int did_sid);

	/**
	* @Title: selectSensorData
	* @Description: selectSensorData
	* @param：Device
	* @return：返回json处理过的字符串
	* @throws：
	 */
	public String selectSensorData(int did_sid);
	
}
