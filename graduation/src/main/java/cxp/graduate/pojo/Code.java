package cxp.graduate.pojo;

import java.io.Serializable;

public class Code implements Serializable{
	/**
	 * @ClassName：
	 * @Description:
	 * @date:
	 */
	
	private static final long serialVersionUID = 1L;
	/**
	 * @ClassName：Code
	 * @Description: 激活码过程的实体类
	 * @date:
	 */
	private String uniqueCode;
	private String activateCode;
	public String getUniqueCode() {
		return uniqueCode;
	}
	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}
	public String getActivateCode() {
		return activateCode;
	}
	public void setActivateCode(String activateCode) {
		this.activateCode = activateCode;
	}
	
}
