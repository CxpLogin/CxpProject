package cxp.graduate.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName：SensorData
 * @Description: 传感器数据
 * @date: 2019-03-11 V1.1
 */
public class Sensor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String intime;
	private float mq2;
	private float dht11;
	private float flame;
	private int did_sid;
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	public float getMq2() {
		return mq2;
	}
	public void setMq2(float mq2) {
		this.mq2 = mq2;
	}
	
	public float getDht11() {
		return dht11;
	}
	public void setDht11(float dht11) {
		this.dht11 = dht11;
	}
	
	public float getFlame() {
		return flame;
	}
	public void setFlame(float flame) {
		this.flame = flame;
	}
	public int getDid_sid() {
		return did_sid;
	}
	public void setDid_sid(int did_sid) {
		this.did_sid = did_sid;
	}
	@Override
	public String toString() {
		return "Sensor [intime=" + intime + ", mq2=" + mq2 + ", dht11=" + dht11 + ", flame=" + flame + ", did_sid="
				+ did_sid + "]";
	}
	
}
