package cxp.graduate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cxp.graduate.mapper.SensorMapper;
import cxp.graduate.pojo.Page;
import cxp.graduate.pojo.Sensor;
import cxp.graduate.service.SensorService;
import net.sf.json.JSONArray;


@Service("sensorService")
public class SensorServiceImpl implements SensorService {

	@Autowired
	private SensorMapper sensorMapper;

	@Override
	public void insertSensorData(Sensor sensor) {
		// TODO Auto-generated method stub
		sensorMapper.insertSensorData(sensor);
	}

	@Override
	public List<Sensor> selectSensorSetAddr(int did_sid) {
		// TODO Auto-generated method stub
		return sensorMapper.selectSensorSetAddr(did_sid);
	}

	@Override
	public String selectSensorData(int did_sid) {
		// TODO Auto-generated method stub
		List<Sensor> list = sensorMapper.selectByDid(did_sid);
		JSONArray jsonArray = JSONArray.fromObject(list);
		return jsonArray.toString();
	}

	@Override
	public int getTotalCount(Page page) {
		// TODO Auto-generated method stub
		return sensorMapper.getTotalCount(page);
	}

	@Override
	public List<Sensor> selectSensorMsg(Page page) {
		// TODO Auto-generated method stub
		return sensorMapper.selectSensorMsg(page);
	}
	
}
