package cxp.graduate.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javafx.scene.chart.XYChart.Series;

/**
 * 
 * @ClassName:  ChartController   
 * @Description:负责显示图表信息（日表数据、周表数据、月表数据、年表数据） 
 * @date:   2018年11月19日 下午5:12:37
 */
@Controller
@RequestMapping("/user/chart")
public class ChartController {
	
	@RequestMapping(value="/daysView",produces="text/html;charset=UTF-8")
    public @ResponseBody String daysView() {
		List<String> xAxisData = new ArrayList<String>();
		xAxisData.add("星期一");
		xAxisData.add("星期二");
		xAxisData.add("星期三");
		xAxisData.add("星期四");
		xAxisData.add("星期五");
		xAxisData.add("星期六");
		xAxisData.add("星期天");
		List<String> yAxisData = new ArrayList<String>();
		yAxisData.add("20");
		yAxisData.add("22");
		yAxisData.add("24");
		yAxisData.add("26");
		yAxisData.add("28");
		yAxisData.add("30");
		yAxisData.add("32");
		//将x、y轴的东西转成json格式
		JSONObject jsob = new JSONObject(); 
        jsob.put("xAxisData", xAxisData);
        jsob.put("yAxisData", yAxisData);
		return jsob.toString();
    }
}
