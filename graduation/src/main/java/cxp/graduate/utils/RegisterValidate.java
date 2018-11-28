package cxp.graduate.utils;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * 
 * @ClassName:  RegisterValidate   
 * @Description:发送验证码 
 * @date:   2018年11月27日 下午4:06:28
 */
public class RegisterValidate {
	//发送激活码及链接
	public void sendEmail(String email,String code) {
		//创建邮件发送服务器
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();  
        mailSender.setHost("smtp.163.com");
        //mailSender.setPort(465);
        mailSender.setUsername("Cxp96x@163.com");
        mailSender.setPassword("Chen1314");//POP3/SMTP服务授权码
        
        //加认证机制
        Properties javaMailProperties = new Properties();
    	javaMailProperties.put("mail.smtp.auth", true); 
    	javaMailProperties.put("mail.smtp.starttls.enable", true); 
    	javaMailProperties.put("mail.smtp.timeout", 5000); 
        mailSender.setJavaMailProperties(javaMailProperties);
        
        //创建邮件内容
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("Cxp96x@163.com");
        message.setTo(email);
        message.setSubject("基于GPRS家庭火灾监控系统");//主题
        System.out.println(code);
        message.setText("http://localhost:8080/graduation/user/email?email=" + email + "&code=" + code);// 邮件内容
       
        //发送邮件
        mailSender.send(message);
	}
}
