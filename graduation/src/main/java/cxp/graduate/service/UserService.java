package cxp.graduate.service;

import cxp.graduate.pojo.User;

public interface UserService {
	/**
 	* @Title: findUserByName
	* @Description: 根据用户名和密码查询用户是否能登录。
	* @param：
	* @return：User
	* @throws：
	 */
	public User findUserByName(String u_name);

	/**
	* @Title: findUserByEmainl
	* @Description: 根据邮箱查询用户
	* @param：findUserByEmainl
	* @return：User
	* @throws：
	 */
	public User findUserByEmainl(String u_email);

	/**
	* @Title: saveUser
	* @Description: 插入用户的同时返回当前用户id
	* @param：User
	* @return：int
	* @throws：
	 */
	public int saveUser(User user);

	/**
	* @Title: findUser
	* @Description: 根据用户名和密码查询用户
	* @param：User
	* @return：int
	* @throws：
	 */
	public User findUser(User user);


	/**
	* @Title: updateActDevice
	* @Description: 激活用户设备状态
	* @param：User
	* @return：void
	* @throws：
	 */
	public void updateActDevice(User user);

	/**
	* @Title: updateCode
	* @Description: 更新用户邮箱状态
	* @param：User
	* @return：void
	* @throws：
	 */
	public void updateEmailCode(User user);
}
