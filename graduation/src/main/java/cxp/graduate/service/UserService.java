package cxp.graduate.service;

import cxp.graduate.pojo.User;

public interface UserService {
	
	/**
	 * service层查询
	 * @param user
	 * @return user
	 */
	public User findUser(User user);
}
