package cxp.graduate.mapper;

import java.util.List;

import cxp.graduate.pojo.User;

public interface UserMapper {
	
	/**
	 * 查询是否存在用户
	 * @param user
	 * @return user
	 */
	public User findUser(User user);
	
	/**
	 * 根据用户名查询用户是否存在
	 * @param name
	 * @return User
	 */
	public User findUserByName(String name);
	
	/**
	 * 查询用户名下的设备
	 * @param id
	 * @return List<User>
	 */
	public List<User> selectUserDevice(int id);
	
	/**
	 * 查询用户注册信息
	 * @param id
	 * @return List<User>
	 */
	public List<User> selectUserRegist(int id);
	
	/**
	 * 插入用户返回自增主键id
	 * @param u
	 * @return
	 */
	public int insertUser(User u); 
}
