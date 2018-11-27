package cxp.graduate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cxp.graduate.mapper.UserMapper;
import cxp.graduate.pojo.User;
import cxp.graduate.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.findUser(user);
	}

}
