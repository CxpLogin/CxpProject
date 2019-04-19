package cxp.graduate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cxp.graduate.mapper.UserMapper;
import cxp.graduate.pojo.User;
import cxp.graduate.service.UserService;
import cxp.graduate.utils.CodeFactory;
import cxp.graduate.utils.UserResultUtils;
import net.sf.json.JSONObject;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUserByName(String u_name) {
		// TODO Auto-generated method stub
		return userMapper.findUserByName(u_name);
	}

	@Override
	public User findUserByEmainl(String u_email) {
		// TODO Auto-generated method stub
		return userMapper.findUserByEmainl(u_email);
	}

	@Override
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		//获取自增主键ID
		if(userMapper.saveUser(user) > 0) {
			User getUser = userMapper.findUserByName(user.getU_name());
			return getUser.getU_id();
		}else {
			return 0;
		}
	}

	@Override
	public User findUser(User user) {
		// TODO Auto-generated method stub
		CodeFactory codeFactory = new CodeFactory();
		System.out.println("用户提交密码" + user.getU_pwd());
		String pwd = codeFactory.encrypt(user.getU_pwd());
		System.out.println("加密后密码" + pwd);
		user.setU_pwd(pwd);
		return userMapper.findUser(user);
	}

	@Override
	public void updateActDevice(User user) {
		// TODO Auto-generated method stub
		userMapper.updateActDevice(user);
	}

	@Override
	public void updateEmailCode(User user) {
		// TODO Auto-generated method stub
		userMapper.updateEmailCode(user);
	}
	
}
