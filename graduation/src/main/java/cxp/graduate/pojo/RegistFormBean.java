package cxp.graduate.pojo;

import java.io.Serializable;

/**
 * 
 * @ClassName:  RegistFormBean   
 * @Description:注册表单Bean  
 * @date:   2018年11月27日 下午2:22:19
 */
public class RegistFormBean implements Serializable{

	private static final long serialVersionUID = -7706823886371912685L;
	
	private String registName;
	private String registPwd;
	private String registEmail;
	public String getRegistName() {
		return registName;
	}
	public void setRegistName(String registName) {
		this.registName = registName;
	}
	public String getRegistPwd() {
		return registPwd;
	}
	public void setRegistPwd(String registPwd) {
		this.registPwd = registPwd;
	}
	public String getRegistEmail() {
		return registEmail;
	}
	public void setRegistEmail(String registEmail) {
		this.registEmail = registEmail;
	}
}
