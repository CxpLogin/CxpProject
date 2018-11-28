package cxp.graduate.service.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cxp.graduate.mapper.UserMapper;
import cxp.graduate.pojo.User;
import cxp.graduate.service.UserService;
import cxp.graduate.utils.UserResultUtils;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.findUser(user);
	}

	@Override
	public User findUserByName(String name) {
		// TODO Auto-generated method stub
		return userMapper.findUserByName(name);
	}

	@Override
	public int getUserId(User user) {
		// TODO Auto-generated method stub
		userMapper.insertUser(user);
		return user.getUserId();
	}

}
