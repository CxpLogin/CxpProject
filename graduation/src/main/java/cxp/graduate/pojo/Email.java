package cxp.graduate.pojo;

import java.io.Serializable;

public class Email implements Serializable{
	
	private static final long serialVersionUID = 2771389358204930246L;
	
	private int id;
	private String email;
	private boolean state;
	private String date;
	private String code;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "RegistInfoBean [id=" + id + ", email=" + email + ", state=" + state + ", date=" + date + "]";
	}
}
