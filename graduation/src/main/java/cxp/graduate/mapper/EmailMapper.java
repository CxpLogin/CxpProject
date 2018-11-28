package cxp.graduate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cxp.graduate.pojo.Admin;
import cxp.graduate.pojo.Email;
import cxp.graduate.pojo.User;

public interface EmailMapper {
	
	/**
	 * 根据用户名查询用户是否存在
	 * @param name
	 * @return User
	 */
	public Email findEmailByName(String name);

	/**
	 * 插入邮箱
	 * @param email
	 */
	public void insertEmail(Email email);
	
	@Select("select code from regist where email=#{emailName}")
	public String findEmailCode(String emailName);

	@Select("update regist set state=1 where email=#{emailName}")
	public void updateEmailState(String emailName);
	
	@Select("update regist set uid_rid = #{id} where email = #{emailName}")
	public void updateEmailUid(@Param("id")int id,@Param("emailName")String emailName);
}
