package cxp.graduate.pojo;

import java.io.Serializable;
import java.util.List;

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
	
	//一个用户具有多个设备，但一个设备仅有一个用户（一对多配置）
	private List<Device> devices;
	//利用另一张表来记录注册信息
	private Email email;
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
	public List<Device> getDevices() {
		return devices;
	}
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", devices=" + devices
				+ ", email=" + email + "]";
	}
}
