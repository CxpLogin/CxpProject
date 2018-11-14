package cxp.graduate.pojo;

/**
 * 
 * @ClassName:  Admin   
 * @Description:管理员权限的设置  
 * @date:   2018年11月13日 下午12:42:15
 */
public class Admin {
	private String aduser;
	public String getAduser() {
		return aduser;
	}
	public void setAduser(String aduser) {
		this.aduser = aduser;
	}
	public String getAdpwd() {
		return adpwd;
	}
	public void setAdpwd(String adpwd) {
		this.adpwd = adpwd;
	}
	private String adpwd;
	@Override
	public String toString() {
		return "Admin [aduser=" + aduser + ", adpwd=" + adpwd + "]";
	}
	
}
