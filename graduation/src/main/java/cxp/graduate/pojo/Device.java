package cxp.graduate.pojo;

import java.io.Serializable;

public class Device implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * @ClassName：Device
	 * @Description: 设备信息的Bean
	 * @date: 2019-03-07 V1.1
	 */
	
	private int deviceID;//设备主键ID
	private String uniqueID;//设备唯一指定ID
	private String deviceAddr;//设备地址
	private String activateTime;//设备激活时间
	private String activateCode;//设备激活码
	private boolean activate;//设备是否激活
	private boolean MQ2Switch;
	private boolean DHT11Switch;
	private boolean FLAMESwitch;
	public int getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(int deviceID) {
		this.deviceID = deviceID;
	}
	public String getUniqueID() {
		return uniqueID;
	}
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	public String getDeviceAddr() {
		return deviceAddr;
	}
	public void setDeviceAddr(String deviceAddr) {
		this.deviceAddr = deviceAddr;
	}
	public String getActivateTime() {
		return activateTime;
	}
	public void setActivateTime(String activateTime) {
		this.activateTime = activateTime;
	}
	public String getActivateCode() {
		return activateCode;
	}
	public void setActivateCode(String activateCode) {
		this.activateCode = activateCode;
	}
	public boolean isActivate() {
		return activate;
	}
	public void setActivate(boolean activate) {
		this.activate = activate;
	}
	public boolean isMQ2Switch() {
		return MQ2Switch;
	}
	public void setMQ2Switch(boolean mQ2Switch) {
		MQ2Switch = mQ2Switch;
	}
	public boolean isDHT11Switch() {
		return DHT11Switch;
	}
	public void setDHT11Switch(boolean dHT11Switch) {
		DHT11Switch = dHT11Switch;
	}
	public boolean isFLAMESwitch() {
		return FLAMESwitch;
	}
	public void setFLAMESwitch(boolean fLAMESwitch) {
		FLAMESwitch = fLAMESwitch;
	}
	
	
	//{"total":1,"message":"hello","rows":{"item":[{"deviceAddr":"广西南宁","activateCode":"KOPLIU","DHT11Switch":true,"FLAMESwitch":true,"activate":true,"activateTime":"2019-03-07","deviceID":1,"MQ2Switch":true,"uniqueID":"CKLOPD"}]},"status":200}
	
	

}
