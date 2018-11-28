package cxp.graduate.pojo;

/**
 * 
 * @ClassName:  Form   
 * @Description:获取表单的数据  
 * @date:   2018年11月27日 上午11:18:42
 */
public class LoginFormBean {
	private String loginName;
	private String loginPwd;
	private String type;
	private String code;
	private boolean isRemeber;
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isRemeber() {
		return isRemeber;
	}
	public void setRemeber(boolean isRemeber) {
		this.isRemeber = isRemeber;
	}
	
}
