package cxp.graduate.json;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * @ClassName:  JsonDemo   
 * @Description:测试JSON的功能 
 * @date:   2018年11月21日 上午10:38:18
 */
public class JsonDemo {
	
	/**
	 * 将Days对象封装成json格式字符串
	 * */
	@Test
	public void demo() {
		//1、创建Days对象并实例化
		Days days = new Days();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		
		days.setD_dat(date);
		days.setD_smoke(25.23f);
		days.setD_temperature(16.22f);
		days.setD_infrared(30.33f);
		System.out.println(days);
		//Days [d_dat=2018-11-21, d_smoke=25.23, d_temperature=16.22, d_infrared=30.33]
		
		//2、将其转成JSON字符串JSONObject
		JSONObject json = JSONObject.fromObject(days);
		System.out.println(json.toString());
		//{"d_dat":"2018-11-21","d_smoke":25.23,"d_infrared":30.33,"d_temperature":16.22}
		
		//2、将其转成JSON字符串JSONArray
		JSONArray array = JSONArray.fromObject(days);
		System.out.println(array.toString());
		//[{"d_dat":"2018-11-21","d_smoke":25.23,"d_infrared":30.33,"d_temperature":16.22}]
	}
	
	/**
	 * 将JSON字符串转成java对象
	 */
	@Test
	public void demo1() {
		//定义两种不同格式的字符串
		String objectJson = "{\"d_dat\":\"2018-11-21\",\"d_smoke\":25.23,\"d_infrared\":30.33,\"d_temperature\":16.22}";
		String arrayJson = "[{\"d_dat\":\"2018-11-21\",\"d_smoke\":25.23,\"d_infrared\":30.33,\"d_temperature\":16.22}]";
		
		//1、使用JSONObject
		JSONObject jsonObject = JSONObject.fromObject(objectJson);
		Days days = (Days) JSONObject.toBean(jsonObject,Days.class);
		System.out.println(days);
		
		//2、使用 JSONArray
		JSONArray jsonArray = JSONArray.fromObject(arrayJson);
		Object o=jsonArray.get(0);
		JSONObject jsonObject2=JSONObject.fromObject(o);
		Days day = (Days) JSONObject.toBean(jsonObject2,Days.class);
		System.out.println(day);
	}
	
	/**
	 * 将list转成json字符串
	 */
	@Test
	public void demo2() {
		//1、创建Days对象并实例化
		Days days = new Days();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		days.setD_dat(date);
		days.setD_smoke(25.23f);
		days.setD_temperature(16.22f);
		days.setD_infrared(30.33f);
		
		Days day = new Days();
		day.setD_dat(date);
		day.setD_smoke(35.23f);
		day.setD_temperature(26.22f);
		day.setD_infrared(40.33f);
		
		List<Days> list = new ArrayList<Days>();
		list.add(days);
		list.add(day);
		
		//2、使用JSONObject(经测试无法使用)
//		JSONObject jsonObject = JSONObject.fromObject(list);
//		System.out.println(list.toString());
		
		//3、使用 JSONArray
		JSONArray jsonArray = JSONArray.fromObject(list);
		System.out.println(jsonArray.toString());
		/*
		 * 一个对象：[{"d_dat":"2018-11-21","d_smoke":25.23,"d_infrared":30.33,"d_temperature":16.22}]
		 * 多个对象：
		 * [{"d_dat":"2018-11-21","d_smoke":25.23,"d_infrared":30.33,"d_temperature":16.22},
		 * {"d_dat":"2018-11-21","d_smoke":35.23,"d_infrared":40.33,"d_temperature":26.22}]
		 * */
	}
	
	/**
	 * json字符串转成list
	 */
	@Test
	public void demo3() {
		String listArray = "[{\"d_dat\":\"2018-11-21\",\"d_smoke\":25.23,\"d_infrared\":30.33,\"d_temperature\":16.22},{\"d_dat\":\"2018-11-21\",\"d_smoke\":35.23,\"d_infrared\":40.33,\"d_temperature\":26.22}]";
		//转化为list
		List<Days> list=(List<Days>)JSONArray.toList(JSONArray.fromObject(listArray), Days.class);
		for (Days days : list) {
			System.out.println(days);
		}
		//转为数组
		Days[] daysArray =(Days[])JSONArray.toArray(JSONArray.fromObject(listArray),Days.class);
		for (Days days : daysArray) {
			System.out.println(days);
		}
	}
	
	/**
	 * 将map转成json
	 */
	@Test
	public void demo4() {
		//1、创建Days对象并实例化
		Days days = new Days();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		days.setD_dat(date);
		days.setD_smoke(25.23f);
		days.setD_temperature(16.22f);
		days.setD_infrared(30.33f);
		
		Days day = new Days();
		day.setD_dat(date);
		day.setD_smoke(35.23f);
		day.setD_temperature(26.22f);
		day.setD_infrared(40.33f);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("first", days);
		map.put("second", day);
		
		//2、使用JSONObject
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println(jsonObject.toString());
		
		//3、使用 JSONArray
		JSONArray jsonArray = JSONArray.fromObject(map);
		System.out.println(jsonArray.toString());
		
		/*
		 * {"first":{"d_dat":"2018-11-21","d_smoke":25.23,"d_infrared":30.33,"d_temperature":16.22},
		 * "second":{"d_dat":"2018-11-21","d_smoke":35.23,"d_infrared":40.33,"d_temperature":26.22}}
		 * [{"first":{"d_dat":"2018-11-21","d_smoke":25.23,"d_infrared":30.33,"d_temperature":16.22},
		 * "second":{"d_dat":"2018-11-21","d_smoke":35.23,"d_infrared":40.33,"d_temperature":26.22}}]
		 * 
		 * */
	}
	
	/**
	 * 将json串转成map
	 * */
	public void demo5() {
		String mapString = "{\"first\":{\"d_dat\":\"2018-11-21\",\"d_smoke\":25.23,\"d_infrared\":30.33,\"d_temperature\":16.22},\"second\":{\"d_dat\":\"2018-11-21\",\"d_smoke\":35.23,\"d_infrared\":40.33,\"d_temperature\":26.22}}";
		//JSONObject
		JSONObject jsonObject=JSONObject.fromObject(mapString);
		Map map=new HashMap();
		map.put("first", Days.class);
		//使用了toBean方法，需要三个参数 
//		MyBean my=(MyBean)JSONObject.toBean(jsonObject, MyBean.class, map);
//		System.out.println(my.getFirst());

		/*
		 *  public class MyBean {
			private Student first;
			public Student getFirst() {
			return first;
			}
			public void setFirst(Student first) {
			this.first = first;
			}
			}
		 * 
		 * */
		
	}
}
