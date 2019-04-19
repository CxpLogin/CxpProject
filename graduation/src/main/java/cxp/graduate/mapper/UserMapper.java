package cxp.graduate.mapper;

import java.util.List;

import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.User;

public interface UserMapper {
	
	/**
	 * 
	* @Title: findUser
	* @Description: 根据用户名和密码查询是否存在用户
	* @param：User
	* @return：User
	* @throws：
	 */
	public User findUser(User user);
	
	/**
	* @Title: findUserByName
	* @Description: 注册时需要查询用户名是否被使用过
	* @param：String
	* @return：User
	* @throws：
	 */
	public User findUserByName(String u_name);

	/**
	* @Title: findUserEmail
	* @Description: 注册时需要查询用户邮箱是否被使用过
	* @param：String
	* @return：User
	* @throws：
	 */
	public User findUserByEmainl(String u_email);	


	/**
	* @Title: saveUser
	* @Description: 保存用户名、密码和邮箱,返回用户自增组件
	* @param：User
	* @return：void
	* @throws：
	 */
	public int saveUser(User user);

	/**
	* @Title: updateCode
	* @Description: 更新用户邮箱状态
	* @param：User
	* @return：void
	* @throws：
	 */
	public void updateCode(User user);

	/**
	* @Title: updateAct
	* @Description: 激活用户设备状态
	* @param：User
	* @return：void
	* @throws：
	 */
	public void updateAct(User user);

	/**
	* @Title: findUserPwd
	* @Description: 得到用户密码
	* @param：String
	* @return：String
	* @throws：
	 */
	public String findUserPwd(String email);
	
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
