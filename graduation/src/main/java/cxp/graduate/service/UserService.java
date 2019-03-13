package cxp.graduate.service;

import cxp.graduate.pojo.User;

public interface UserService {
	
	/**
	 * 
	* @Title: findUserByName
	* @Description: 根据用户名和密码查询用户是否能登录。
	* @param：
	* @return：User
	* @throws：
	 */
	public User findUserByName(User user);
	
	/**
	 * 
	* @Title: findUserByName
	* @Description: 
	* @param：
	* @return：
	* @throws：
	 */
	public String findUserByName(String name);
	
	/**
	 * 
	* @Title: findUser
	* @Description: 根据用户名查询用户
	* @param：
	* @return：
	* @throws：
	 */
	public User findUser(String name);
	
	
	/**
	 * 
	* @Title: findDeviceByID
	* @Description: 查询用户是否激活
	* @param：
	* @return：
	* @throws：
	 */
	public boolean findDeviceByID(int userID);
	
	/**
	 * 
	* @Title: findUserEmail
	* @Description: 查询是否存在邮箱
	* @param：
	* @return：
	* @throws：
	 */
	public String findUserEmail(String emailName);
	
	/**
	 * 
	* @Title: getUserId
	* @Description: 插入用户的同时返回当前用户id
	* @param：
	* @return：
	* @throws：
	 */
	public int saveUser(User user);
	
}
