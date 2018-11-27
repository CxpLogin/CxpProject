package cxp.graduate.pojo;

/**
 * 
 * @ClassName:  Form   
 * @Description:获取表单的数据  
 * @date:   2018年11月27日 上午11:18:42
 */
public class LoginFormBean {
	private String baseName;
	private String basePwd;
	private String type;
	private String code;
	private boolean isRemeber;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBaseName() {
		return baseName;
	}
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}
	public String getBasePwd() {
		return basePwd;
	}
	public void setBasePwd(String basePwd) {
		this.basePwd = basePwd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isRemeber() {
		return isRemeber;
	}
	public void setRemeber(boolean isRemeber) {
		this.isRemeber = isRemeber;
	}
	 
	
}
