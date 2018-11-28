package cxp.graduate.junit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cxp.graduate.mapper.EmailMapper;
import cxp.graduate.mapper.UserMapper;
import cxp.graduate.pojo.Email;
import cxp.graduate.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)//帮我们创建容器
@ContextConfiguration("classpath:applicationContext.xml")//指定创建容器时使用哪个配置文件
public class EmailJunit {                        
	
	@Autowired
	private EmailMapper emailMapper;
	
	/*根据邮箱名查询邮箱是否存在*/
	@Test
	public void demo() {
		String email = "810756933@qq.com";
		Email e = emailMapper.findEmailByName(email);
		System.out.println(e);
	}
	
	/*插入数据*/
	@Test
	public void demo1() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		Email email = new Email();
		email.setEmail("810756933@qq.com");
		email.setCode("zx12");
		email.setDate(date);
		email.setState(false);
		System.out.println(email);
		emailMapper.insertEmail(email);
	}
	
	//获取激活码
	@Test
	public void demo2() {
		System.out.println(emailMapper.findEmailCode("757205175@qq.com"));
	}
	
	//更新激活
	@Test
	public void demo3() {
		emailMapper.updateEmailState("757205175@qq.com");
	}
	
	//加上外键
	@Test
	public void demo4() {
		emailMapper.updateEmailUid(1,"757205175@qq.com");
	}
}
	