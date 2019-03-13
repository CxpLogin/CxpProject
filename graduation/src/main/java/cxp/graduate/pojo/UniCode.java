package cxp.graduate.pojo;

import java.io.Serializable;

/**
 * @ClassName：UniCode
 * @Description: 设备码的bean
 * @date: 2019-03-13 V1.1
 */
public class UniCode implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int did_uin;
	private String code;
	public int getDid_uin() {
		return did_uin;
	}
	public void setDid_uin(int did_uin) {
		this.did_uin = did_uin;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "UniCode [did_uin=" + did_uin + ", code=" + code + "]";
	}
	
}
