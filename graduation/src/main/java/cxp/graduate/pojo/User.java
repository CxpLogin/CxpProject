package cxp.graduate.pojo;

import java.io.Serializable;

/**
 * 
 * @ClassName:  User   
 * @Description:普通用户的bean 
 * @date:   2018年11月23日 下午5:44:21
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 898474463888824242L;
	
	private String userName;
	private String userPwd;

	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPwd=" + userPwd + "]";
	}
}
