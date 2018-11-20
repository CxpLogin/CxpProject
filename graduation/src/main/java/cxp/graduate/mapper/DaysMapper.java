package cxp.graduate.mapper;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import cxp.graduate.pojo.Days;

/**
 * 
 * @ClassName:  DaysMapper   
 * @Description:模拟从数据库中获取某一天三个模块的数据 
 * @date:   2018年11月20日 下午1:04:54
 */

public interface DaysMapper {
	/*获取某一天的三个模块的数据*/
	public List<Days> getDataByDay(String string);
}