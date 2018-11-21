package cxp.graduate.json;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cxp.graduate.mapper.DaysMapper;
import cxp.graduate.pojo.Days;
import cxp.graduate.service.DaysService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * @ClassName:  DBJunit   
 * @Description:获取数据库数据并转成json数据 
 * @date:   2018年11月21日 下午12:00:20
 */
@RunWith(SpringJUnit4ClassRunner.class)//帮我们创建容器
@ContextConfiguration("classpath:applicationContext.xml")//指定创建容器时使用哪个配置文件
public class DBJunit {
	
	@Autowired
	private DaysService daysService;
	
	
	@Test
	public void demo() {
		//由于取出的日期为java.sql.Date，而定义的却为java.util.Date。转成json出错(为了通用性，将日期改成String类型)
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		
		List<Days> list = daysService.getDataByDay(date);
		//通用性之后需要将取出的java.sql.Date封装成String
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setD_dat(date);
		}
		
		//使用JSONArray
		JSONArray json = JSONArray.fromObject(list);
		System.out.println(json.toString());
	}
}
