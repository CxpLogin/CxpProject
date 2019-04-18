package com.cxp.junit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.collections.OrderedMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cxp.graduate.mapper.OrderMapper;
import cxp.graduate.pojo.ControlOrder;
import cxp.graduate.service.OrderService;


@RunWith(SpringJUnit4ClassRunner.class)//帮我们创建容器
@ContextConfiguration("classpath:applicationContext.xml")//指定创建容器时使用哪个配置文件
public class OrderJuint {                        
	
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderService orderService;
	
	//查询标志位
	@Test
	public void demo() throws ParseException {
		/*
		ControlOrder order = orderMapper.selectFlag(1);
		System.out.println(order);
		if(order.isC_flag()) {
			order.setC_alarm(false);
			order.setC_relay(false);
			order.setC_flag(false);
			order.setCid_did(1);
			orderMapper.updateOrder(order);
		}
		System.out.println(order);
		*/
		ControlOrder order = orderService.selectFlag(1);
		System.out.println(order);
//		if(order.isC_flag()) {
//			order.setC_alarm(false);
//			order.setC_relay(false);
//			order.setC_flag(false);
//			order.setCid_did(1);
//			orderService.updateOrder(order);
//		}
//		System.out.println(order);
	}

	
}