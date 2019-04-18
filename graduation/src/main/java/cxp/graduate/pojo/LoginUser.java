package cxp.graduate.pojo;

/**
 * @ClassName：LoginUser
 * @Description: 登录用户的表单
 * @date: 2019-04-17
 */
public class LoginUser {
	private String userName;
	private String userPwd;
	private String code;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "LoginUser [userName=" + userName + ", userPwd=" + userPwd + ", code=" + code + "]";
	}
}
