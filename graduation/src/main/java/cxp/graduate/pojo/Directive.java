package cxp.graduate.pojo;

import java.io.Serializable;

/**
 * @ClassName：Directive
 * @Description: 匹配数据库的指令
 * @date:
 */
public class Directive implements Serializable{
	
	private static final long serialVersionUID = 2014060440013301792L;

	private boolean c_relay;
	private boolean c_alarm;
	private boolean c_flag;
	private int did_oid;
	public boolean isC_relay() {
		return c_relay;
	}
	public void setC_relay(boolean c_relay) {
		this.c_relay = c_relay;
	}
	public boolean isC_alarm() {
		return c_alarm;
	}
	public void setC_alarm(boolean c_alarm) {
		this.c_alarm = c_alarm;
	}
	public boolean isC_flag() {
		return c_flag;
	}
	public void setC_flag(boolean c_flag) {
		this.c_flag = c_flag;
	}
	public int getDid_oid() {
		return did_oid;
	}
	public void setDid_oid(int did_oid) {
		this.did_oid = did_oid;
	}
	@Override
	public String toString() {
		return "Directive [c_relay=" + c_relay + ", c_alarm=" + c_alarm + ", c_flag=" + c_flag + ", did_oid=" + did_oid
				+ "]";
	}
	
}
