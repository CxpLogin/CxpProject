package cxp.graduate.pojo;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	/**
	 * @ClassName：User
	 * @Description: 用户登录、注册的Bean
	 * @date: 2019-03-07 v1.1
	 */
	private static final long serialVersionUID = 898474463888824242L;
	
	private int userID;
	private String userName;
	private String userPwd;
	private String userEmail;
	private String registTime;
	private String code;//这是验证码的code
	//一个用户具有多个设备，但一个设备仅有一个用户（一对多配置）
	private List<Device> devices;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
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
	public String getRegistTime() {
		return registTime;
	}
	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<Device> getDevices() {
		return devices;
	}
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", userPwd=" + userPwd + ", userEmail=" + userEmail
				+ ", registTime=" + registTime + ", code=" + code + ", devices=" + devices + "]";
	}

	
}
