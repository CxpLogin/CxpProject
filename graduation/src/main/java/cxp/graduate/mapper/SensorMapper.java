package cxp.graduate.mapper;

import java.util.List;

import cxp.graduate.pojo.Sensor;


public interface SensorMapper {	
	
	/**
	 * 
	* @Title: selectByDid
	* @Description: 同步更新uid_did
	* @param：
	* @return：
	* @throws：
	 */
	public List<Sensor> selectByDid(int did_sid);
	
	/**
	 * 
	* @Title: selectCount
	* @Description: 查询当前是否有10条数据
	* @param：
	* @return：
	* @throws：
	 */
	public int selectCount(int did_sid);
	
	/**
	 * 
	* @Title: deleteFirstTime
	* @Description: 插入的同时删除时间最早的那一条数据
	* @param：
	* @return：
	* @throws：
	 */
	public void deleteFirstTime(int did_sid);
	
	/**
	 * 
	* @Title: insertTime
	* @Description: 插入一条数据
	* @param：
	* @return：
	* @throws：
	 */
	public void insertTime(Sensor sensor);
	
}
