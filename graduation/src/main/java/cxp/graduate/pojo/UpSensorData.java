package cxp.graduate.pojo;

import java.io.Serializable;

/**
 * @ClassName：UpSensorData
 * @Description: JSON封装的传感器数据
 * @date:
 */
public class UpSensorData implements Serializable{
	private static final long serialVersionUID = 1244166695900651732L;
	private String identity;
	private float yanwu;
	private float wendu;
	private float shidu;
	private boolean flame;
	private String setaddr;
	private String gpsaddr;
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public float getYanwu() {
		return yanwu;
	}
	public void setYanwu(float yanwu) {
		this.yanwu = yanwu;
	}
	public float getWendu() {
		return wendu;
	}
	public void setWendu(float wendu) {
		this.wendu = wendu;
	}
	public float getShidu() {
		return shidu;
	}
	public void setShidu(float shidu) {
		this.shidu = shidu;
	}
	public boolean isFlame() {
		return flame;
	}
	public void setFlame(boolean flame) {
		this.flame = flame;
	}
	public String getSetaddr() {
		return setaddr;
	}
	public void setSetaddr(String setaddr) {
		this.setaddr = setaddr;
	}
	public String getGpsaddr() {
		return gpsaddr;
	}
	public void setGpsaddr(String gpsaddr) {
		this.gpsaddr = gpsaddr;
	}
	@Override
	public String toString() {
		return "UpSensorData [identity=" + identity + ", yanwu=" + yanwu + ", wendu=" + wendu + ", shidu=" + shidu
				+ ", flame=" + flame + ", setaddr=" + setaddr + ", gpsaddr=" + gpsaddr + "]";
	}
	
}
