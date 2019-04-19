package cxp.graduate.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName：User
 * @Description: 匹配用户数据库信息
 * @date: 2019-04-18
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = -8216835955028143067L;
	
	private int u_id;
	private String u_name;
	private String u_pwd;
	private String u_email;
	private String u_retime;
	private String u_emailcode;
	private boolean u_isact;
	//一个用户具有多个设备，但一个设备仅有一个用户（一对多配置）
	private List<Device> devices;
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
	public List<Device> getDevices() {
		return devices;
	}
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_name=" + u_name + ", u_pwd=" + u_pwd + ", u_email=" + u_email + ", u_retime="
				+ u_retime + ", u_emailcode=" + u_emailcode + ", u_isact=" + u_isact + ", devices=" + devices + "]";
	}
}
