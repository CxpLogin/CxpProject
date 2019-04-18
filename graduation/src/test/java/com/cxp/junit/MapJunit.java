package com.cxp.junit;

import java.net.MalformedURLException;

import org.junit.Test;
import cxp.graduate.utils.BaiduMapUtils;

public class MapJunit {
	@Test
	public void demo() throws MalformedURLException{
		BaiduMapUtils baidu = new BaiduMapUtils();
		baidu.getGeocoderLatitude("广西南宁");
		baidu.getPosition("110.343968","25.28994");
	}
	
	@Test
	public void demo1(){
		BaiduMapUtils baidu = new BaiduMapUtils();
		String jinweidu = "110.34412982752234-25.289894758021768";
		String[]  strs=jinweidu.split("-");
		String jingdu = strs[0];
		String weidu = strs[1];
		try {
			String str = baidu.getPosition(jingdu,weidu);
			System.out.println(str);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
