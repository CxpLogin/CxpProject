package cxp.graduate.pojo;

import java.io.Serializable;


/**
 * 
 * @ClassName:  Device   
 * @Description:设备实体类 
 * @date:   2018年11月27日 下午1:50:22
 */
public class Device implements Serializable{

	private static final long serialVersionUID = -5071597565587334112L;
	
	private int deviceId;//设备唯一指定ID
	private boolean deviceState;//设备状态
	private int uid_did;
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public boolean isDeviceState() {
		return deviceState;
	}
	public void setDeviceState(boolean deviceState) {
		this.deviceState = deviceState;
	}
	public int getUid_did() {
		return uid_did;
	}
	public void setUid_did(int uid_did) {
		this.uid_did = uid_did;
	}
	
}
