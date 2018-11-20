package cxp.graduate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cxp.graduate.mapper.DaysMapper;
import cxp.graduate.pojo.Days;
import cxp.graduate.service.DaysService;

@Service
public class DaysServiceImpl implements DaysService {
	
	@Autowired
	private DaysMapper daysMapper;

	@Override
	public List<Days> getDataByDay(String date) {
		// TODO Auto-generated method stub
		return daysMapper.getDataByDay(date);
	}
	
}
