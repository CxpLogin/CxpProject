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
	
	UserResultUtils result = new UserResultUtils();
	
	@Override
	public User findUserByName(User user) {
		// TODO Auto-generated method stub
		//首先加密用户的密码
		CodeFactory codeFactory = new CodeFactory();
		System.out.println("用户提交密码" + user.getUserPwd());
		String pwd = codeFactory.encrypt(user.getUserPwd());
		System.out.println("加密后密码" + pwd);
		user.setUserPwd(pwd);
		return userMapper.findUserByName(user);
	}

	@Override
	public boolean findDeviceByID(int userID) {
		// TODO Auto-generated method stub
		return userMapper.findDeviceByID(userID).getDevices().get(0).isActivate();
	}

	@Override
	public String findUserByName(String name) {
		// TODO Auto-generated method stub
		User user = userMapper.selectUserByName(name);
		if(user == null) {
			return result.NameExist;
		}
		return result.NameExisted;
	}

	@Override
	public String findUserEmail(String emailName) {
		// TODO Auto-generated method stub
		return userMapper.findUserEmail(emailName);
	}

	@Override
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		//获取自增主键ID
		if(userMapper.insertUser(user) >0) {
			User getUser = userMapper.selectUserByName(user.getUserName());
			return getUser.getUserID();
		}else {
			return 0;
		}
	}

	@Override
	public User findUser(String name) {
		// TODO Auto-generated method stub
		return userMapper.selectUserByName(name);
	}
}
