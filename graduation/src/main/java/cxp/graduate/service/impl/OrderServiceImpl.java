package cxp.graduate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cxp.graduate.mapper.OrderMapper;
import cxp.graduate.pojo.ControlOrder;

import cxp.graduate.service.OrderService;



@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper ooderMapper;
	
	@Override
	public ControlOrder selectFlag(int cid_did) {
		// TODO Auto-generated method stub
		return ooderMapper.selectFlag(cid_did);
	}

	@Override
	public void updateOrder(ControlOrder order) {
		// TODO Auto-generated method stub
		ooderMapper.updateOrder(order);
	}

	
}
