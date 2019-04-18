package cxp.graduate.pojo;

import java.io.Serializable;

/**
 * @ClassName：device
 * @Description: 设备表
 * @date:
 */
public class Device implements Serializable{
	private static final long serialVersionUID = 1152194497771486295L;
	private int d_id;//设备自增id
	private String d_code;//设备出厂编码
	private String d_physics;//设备经纬度
	private String d_instaladdr;//设备安装地址
	private String d_setaddr;//设备设置安装地址
	private String d_activattime;//设备激活时间
	private boolean d_state;//设备当前状态
	private int uid_did;
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getD_code() {
		return d_code;
	}
	public void setD_code(String d_code) {
		this.d_code = d_code;
	}
	public String getD_physics() {
		return d_physics;
	}
	public void setD_physics(String d_physics) {
		this.d_physics = d_physics;
	}
	public String getD_instaladdr() {
		return d_instaladdr;
	}
	public void setD_instaladdr(String d_instaladdr) {
		this.d_instaladdr = d_instaladdr;
	}
	public String getD_setaddr() {
		return d_setaddr;
	}
	public void setD_setaddr(String d_setaddr) {
		this.d_setaddr = d_setaddr;
	}
	public String getD_activattime() {
		return d_activattime;
	}
	public void setD_activattime(String d_activattime) {
		this.d_activattime = d_activattime;
	}
	public boolean isD_state() {
		return d_state;
	}
	public void setD_state(boolean d_state) {
		this.d_state = d_state;
	}
	public int getUid_did() {
		return uid_did;
	}
	public void setUid_did(int uid_did) {
		this.uid_did = uid_did;
	}
	@Override
	public String toString() {
		return "Device [d_id=" + d_id + ", d_code=" + d_code + ", d_physics=" + d_physics + ", d_instaladdr="
				+ d_instaladdr + ", d_setaddr=" + d_setaddr + ", d_activattime=" + d_activattime + ", d_state="
				+ d_state + ", uid_did=" + uid_did + "]";
	}
	
}
