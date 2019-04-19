package cxp.graduate.pojo;

import java.io.Serializable;

/**
 * @ClassName：Sensor
 * @Description: 匹配数据库传感器数据
 * @date: 2019-04-18
 */
public class Sensor implements Serializable{
	private static final long serialVersionUID = 1244166695900651730L;
	private int s_id;
	private float yanwu;
	private float wendu;
	private float shidu;
	private boolean flame;
	private String setaddr;
	private String gpsaddr;
	private String intime;
	private int did_sid;
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
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
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	public int getDid_sid() {
		return did_sid;
	}
	public void setDid_sid(int did_sid) {
		this.did_sid = did_sid;
	}
	@Override
	public String toString() {
		return "Sensor [s_id=" + s_id + ", yanwu=" + yanwu + ", wendu=" + wendu + ", shidu=" + shidu + ", flame="
				+ flame + ", setaddr=" + setaddr + ", gpsaddr=" + gpsaddr + ", intime=" + intime + ", did_sid="
				+ did_sid + "]";
	}
}
