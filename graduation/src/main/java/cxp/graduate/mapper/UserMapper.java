package cxp.graduate.mapper;

import java.util.List;

import cxp.graduate.pojo.Admin;
import cxp.graduate.pojo.User;

public interface UserMapper {
	
	/**
	 * 查询是否存在用户
	 * @param user
	 * @return user
	 */
	public User findUser(User user);
}
