package cxp.graduate.service;

import cxp.graduate.pojo.User;

public interface UserService {

	/**
	* @Title: findUser
	* @Description: 根据用户名和密码查询用户
	* @param：User
	* @return：findUser
	* @throws：
	 */
	User findUser(User user);
	
	/**
	* @Title: findUserByName
	* @Description: 注册时需要查询用户名是否被使用过
	* @param：String
	* @return：String
	* @throws：
	 */
	String findUserByName(String u_name);
	
	/**
	* @Title: findUserEmail
	* @Description: 注册时需要查询用户邮箱是否被使用过
	* @param：String
	* @return：boolean
	* @throws：
	 */
	boolean findUserEmail(String u_email);
	
	/**
	* @Title: saveUser
	* @Description: 保存用户名、密码和邮箱
	* @param：User
	* @return：void
	* @throws：
	 */
	void saveUser(User user);
	
	/**
	* @Title: updateCode
	* @Description: 更新用户邮箱状态
	* @param：User
	* @return：void
	* @throws：
	 */
	void updateCode(User user);
	
	/**
	* @Title: updateAct
	* @Description: 激活用户设备状态
	* @param：User
	* @return：void
	* @throws：
	 */
	void updateAct(User user);

	/**
	* @Title: findUserPwd
	* @Description: 根据邮箱获取密码
	* @param：String
	* @return：String
	* @throws：
	 */
	String findUserPwd(String email);
	
	
}
