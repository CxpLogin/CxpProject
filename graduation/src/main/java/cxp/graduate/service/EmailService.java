package cxp.graduate.service;

import cxp.graduate.pojo.Email;

public interface EmailService {
	
	/**
	 * 返回是否存在email
	 * @param str
	 * @return String
	 */
	public Email findEmailName(String name);
	
	/**
	 * 将当前注册email插入数据库
	 * @param email
	 */
	public void insertEamil(Email email);
	
	/**
	 * 获取数据库中的激活码
	 * @param emailName
	 * @return
	 */
	public String findEmailCode(String emailName);
	
	/**
	 * 更新状态
	 * @param emailName
	 */
	public void updateEmailState(String emailName);
	
	/**
	 * 更新外键
	 * @param emailName
	 */
	public void updateEmailUid(int id,String emailName);
}
