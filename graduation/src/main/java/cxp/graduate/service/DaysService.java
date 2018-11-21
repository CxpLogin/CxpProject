package cxp.graduate.service;

import java.util.List;

import cxp.graduate.pojo.Days;

public interface DaysService {
	
	public List<Days> getDataByDay(String date);
	
	
	public boolean saveData(Days days);
}
