package cxp.graduate.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Days implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Date d_dat;
	private float d_smoke;
	private float d_temperature;
	private float d_infrared;
	public Date getD_dat() {
		return d_dat;
	}
	public void setD_dat(Date d_dat) {
		this.d_dat = d_dat;
	}
	public float getD_smoke() {
		return d_smoke;
	}
	public void setD_smoke(float d_smoke) {
		this.d_smoke = d_smoke;
	}
	public float getD_temperature() {
		return d_temperature;
	}
	public void setD_temperature(float d_temperature) {
		this.d_temperature = d_temperature;
	}
	public float getD_infrared() {
		return d_infrared;
	}
	public void setD_infrared(float d_infrared) {
		this.d_infrared = d_infrared;
	}
	@Override
	public String toString() {
		return "Days [d_dat=" + d_dat + ", d_smoke=" + d_smoke + ", d_temperature=" + d_temperature + ", d_infrared="
				+ d_infrared + "]";
	}
}
