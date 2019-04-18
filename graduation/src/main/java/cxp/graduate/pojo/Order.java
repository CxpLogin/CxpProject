package cxp.graduate.pojo;
/**
 * @ClassName：Order
 * @Description: 指令库
 * @date:
 */
public class Order {
	private boolean c_relay;
	private boolean c_alarm;
	private boolean c_flag;
	private int cid_did;
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
	public int getCid_did() {
		return cid_did;
	}
	public void setCid_did(int cid_did) {
		this.cid_did = cid_did;
	}
}
