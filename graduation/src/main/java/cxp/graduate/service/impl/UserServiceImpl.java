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
	public String findUserByName(String u_name) {
		// TODO Auto-generated method stub
		User user = userMapper.findUserByName(u_name);
		if(user == null) {
			return result.NameExist;
		}
		return result.NameExisted;
	}

	@Override
	public boolean findUserEmail(String u_email) {
		// TODO Auto-generated method stub
		User user = userMapper.findUserEmail(u_email);
		if(user == null) {
			return true;
		}
		return false;
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		CodeFactory codeFactory = new CodeFactory();
		user.setU_pwd(codeFactory.encrypt(user.getU_pwd()));
		userMapper.saveUser(user);
	}

	@Override
	public void updateCode(User user) {
		// TODO Auto-generated method stub
		userMapper.updateCode(user);
	}

	@Override
	public void updateAct(User user) {
		// TODO Auto-generated method stub
		userMapper.updateAct(user);
	}

	@Override
	public String findUserPwd(String email) {
		// TODO Auto-generated method stub
		return userMapper.findUserPwd(email);
	}
}
