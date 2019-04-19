package cxp.graduate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cxp.graduate.mapper.OrderMapper;
import cxp.graduate.pojo.Directive;
import cxp.graduate.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper oderMapper;
	
	@Override
	public Directive findDirectiveFlag(int d_id) {
		// TODO Auto-generated method stub
		return oderMapper.findDirectiveFlag(d_id);
	}

	@Override
	public void updateDirectiveFlag(Directive directive) {
		// TODO Auto-generated method stub
		oderMapper.updateDirectiveFlag(directive);
	}

	@Override
	public void updataDirective(Directive directive) {
		// TODO Auto-generated method stub
		oderMapper.updataDirective(directive);
	}

	@Override
	public void updataDirectiveByRelay(Directive directive) {
		// TODO Auto-generated method stub
		oderMapper.updataDirectiveByRelay(directive);
	}

	@Override
	public void updataDirectiveByAlarm(Directive directive) {
		// TODO Auto-generated method stub
		oderMapper.updataDirectiveByAlarm(directive);
	}
	
}
