package cxp.graduate.service;

import cxp.graduate.pojo.User;

public interface UserService {
	
	/**
	 * service层查询
	 * @param user
	 * @return user
	 */
	public User findUser(User user);
	
	/**
	 * 根据名字查询返回user
	 * @param name
	 * @return user
	 */
	public User findUserByName(String name);
	
	/**
	 * 返回自增主键的id
	 * @param user
	 * @return
	 */
	public int getUserId(User user);
}
