package cxp.graduate.mapper;

import java.util.List;

import cxp.graduate.pojo.Page;
import cxp.graduate.pojo.Sensor;

public interface SensorMapper {	
	
	
	public int selectSensorCount(int did_sid);
	
	public void deleteFirstTime(int did_sid);
	
	public void insertSensorData(Sensor sensor);
	
	public List<Sensor> selectSensorSetAddr(int did_sid);

	public List<Sensor> selectByDid(int did_sid);

	public int getTotalCount(Page page);

	public List<Sensor> selectSensorMsg(Page page);	
}
