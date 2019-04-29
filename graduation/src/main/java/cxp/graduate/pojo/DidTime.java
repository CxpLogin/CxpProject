package cxp.graduate.pojo;

import java.io.Serializable;

/**
 * @ClassName：DidTime
 * @Description: 传感器传入参数设备Id,插入时间
 * @date: 2019-04-29
 */
public class DidTime implements Serializable{
	
	private static final long serialVersionUID = 6008193298908441902L;
	private int d_id;
	private String intime;
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	@Override
	public String toString() {
		return "DidTime [d_id=" + d_id + ", intime=" + intime + "]";
	}	
}
