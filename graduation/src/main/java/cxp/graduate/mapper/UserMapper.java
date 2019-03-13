package cxp.graduate.mapper;

import java.util.List;

import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.User;

public interface UserMapper {
	
	/**
	 * 
	* @Title: findUserByName
	* @Description: 查询是否存在用户
	* @param：
	* @return：
	* @throws：
	 */
	public User findUserByName(User user);
	
	/**
	 * 
	* @Title: findUserEmailByName
	* @Description: 根据邮箱查询，是否存在邮箱
	* @param：
	* @return：
	* @throws：
	 */
	public String findUserEmail(String emailName);
	
	/**
	 * 
	* @Title: findUserByName
	* @Description: 查询该用户下的设备信息
	* @param：int userID
	* @return：
	* @throws：
	 */
	public User findDeviceByID(int userID);
	
	/**
	 * 
	* @Title: findUserByName
	* @Description: 根据用户名查询用户是否存在
	* @param：
	* @return：
	* @throws：
	 */
	public User selectUserByName(String name);
	
	/**
	 * 
	* @Title: insertUser
	* @Description: 返回用户自增组件
	* @param：
	* @return：
	* @throws：
	 */
	public int insertUser(User u);
	
	
}
