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

	@Override
	public boolean saveData(Days days) {
		// TODO Auto-generated method stub
		//获取保存的日期
		Days exitDays = daysMapper.selectDay(days.getD_dat());
		//假如检索到以当前参数得到Days为空，则证明数据库不存在该记录
		if(exitDays == null) {
			//执行插入操作
			daysMapper.saveData(days);
			return true;
		}else {
			return false;
		}
	}
	
}
