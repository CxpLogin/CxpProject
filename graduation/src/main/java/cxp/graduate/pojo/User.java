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
	
	private int userId;
	private String userName;
	private String userPwd;
	private String userEmail;
	private boolean isEmailActive;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
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
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public boolean isEmailActive() {
		return isEmailActive;
	}
	public void setEmailActive(boolean isEmailActive) {
		this.isEmailActive = isEmailActive;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", userEmail=" + userEmail
				+ ", isEmailActive=" + isEmailActive + "]";
	}
	
}
