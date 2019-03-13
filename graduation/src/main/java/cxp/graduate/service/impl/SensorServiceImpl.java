package cxp.graduate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cxp.graduate.mapper.SensorMapper;
import cxp.graduate.pojo.Sensor;
import cxp.graduate.service.SensorService;
import net.sf.json.JSONArray;

@Service("sensorService")
public class SensorServiceImpl implements SensorService {

	@Autowired
	private SensorMapper sensorMapper;

	@Override
	public String selectById(int userID) {
		// TODO Auto-generated method stub
		List<Sensor> list = sensorMapper.selectByDid(userID);
		JSONArray jsonArray = JSONArray.fromObject(list);
		return jsonArray.toString();
	}
	

}
