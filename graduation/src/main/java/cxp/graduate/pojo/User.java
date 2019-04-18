package cxp.graduate.pojo;

import java.io.Serializable;

/**
 * @ClassName：User
 * @Description: 用户
 * @date:	
 */
public class User implements Serializable{	
	private static final long serialVersionUID = 1L;
	private int u_id;
	private String u_name;
	private String u_pwd;
	private String u_email;
	private String u_retime;
	private String u_emailcode;
	private boolean u_isact;
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_pwd() {
		return u_pwd;
	}
	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_retime() {
		return u_retime;
	}
	public void setU_retime(String u_retime) {
		this.u_retime = u_retime;
	}
	public String getU_emailcode() {
		return u_emailcode;
	}
	public void setU_emailcode(String u_emailcode) {
		this.u_emailcode = u_emailcode;
	}
	public boolean isU_isact() {
		return u_isact;
	}
	public void setU_isact(boolean u_isact) {
		this.u_isact = u_isact;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_name=" + u_name + ", u_pwd=" + u_pwd + ", u_email=" + u_email + ", u_retime="
				+ u_retime + ", u_emailcode=" + u_emailcode + ", u_isact=" + u_isact + "]";
	}
}
