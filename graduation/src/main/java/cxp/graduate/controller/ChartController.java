package cxp.graduate.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import cxp.graduate.pojo.Days;
import cxp.graduate.service.DaysService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * 
 * @ClassName:  ChartController   
 * @Description:负责显示图表信息（日表数据、周表数据、月表数据、年表数据） 
 * @date:   2018年11月19日 下午5:12:37
 */
@Controller
@RequestMapping("/user/chart")
public class ChartController {
	
	@Autowired
	private DaysService DaysService;
	
	@RequestMapping(value="/daysView",produces="text/html;charset=UTF-8")
    public @ResponseBody String daysView() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		List<Days> list = DaysService.getDataByDay(date);
		JSONArray json = JSONArray.fromObject(list);
		return json.toString();
    }
}
