package cxp.graduate.pojo;
/**
 * @ClassName：Code
 * @Description: 匹配数据库的出厂编码
 * @date:
 */

import java.io.Serializable;

public class Code implements Serializable{

	private static final long serialVersionUID = -8741406772492848704L;
	
	private String code;
	private int did_cid;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getDid_cid() {
		return did_cid;
	}
	public void setDid_cid(int did_cid) {
		this.did_cid = did_cid;
	}
	@Override
	public String toString() {
		return "Code [code=" + code + ", did_cid=" + did_cid + "]";
	}
	
	
}
	
