package cxp.graduate.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cxp.graduate.mapper.UserMapper;
import cxp.graduate.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)//帮我们创建容器
@ContextConfiguration("classpath:applicationContext.xml")//指定创建容器时使用哪个配置文件
public class UserJunit {                        
	
	@Autowired
	private UserMapper userMapper;
	
	/*检验查询*/
	@Test
	public void demo() {
		User user = new User();
		user.setUserName("陈小培");
		user.setUserPwd("123456");
		User u = userMapper.findUser(user);
		System.out.println(u);
	}
}