package cxp.graduate.utils;

public class UserResultUtils {
	/**
	 * @ClassName：UserResultUtils
	 * @Description: 返回封装类型
	 * @date: 2019-03-07 v1.1
	 */
	
	public static final String LoginError   = "用户名或密码输入不正确";
	public static final String LoginSuccess = "用户名或密码输入正确";
	public static final String LoginIn 		= "已登录";
	public static final String LoginOut 	= "未登录";
	public static final String CodeSuccess  = "验证码正确";
	public static final String CodeError    = "验证码错误";
	public static final String DeviceON     = "设备已激活";
	public static final String DeviceOFF    = "设备未激活";
	public static final String NameExisted  = "该用户名已被使用";
	public static final String NameExist    = "该用户名未被使用";
	public static final String EmailExist   = "该邮箱名已被使用";
	public static final String RegistSuccess= "注册成功";
	public static final String RegistError	= "注册失败";
	
	public static final String UniCodeMsg1	= "查无此设备码";
	public static final String UniCodeMsg2	= "存在此设备码但已被使用";
	public static final String UniCodeMsg3	= "存在此设备码且未被使用";
	public static final String AtiCode		= "激活失败请检查是否输入正确码";
	public static final String EmailError	= "你给定的邮箱和你注册的邮箱不一致";
	public static final String SendEmail	= "验证码已发送到您邮箱，请注意查收";
	public static final String Activate		= "激活成功";
	public static final String SelectError	= "查询失败";
	
	private String message;//错误信息
	private String key;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}
