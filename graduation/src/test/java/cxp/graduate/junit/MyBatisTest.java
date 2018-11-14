package cxp.graduate.junit;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cxp.graduate.mapper.AdminMapper;
import cxp.graduate.pojo.Admin;

public class MyBatisTest {

	//查询所有数据
	@Test
	public void demo() throws IOException {
//		//1、加载核心配置文件
//		InputStream is = Resources.getResourceAsStream("MyBaitsConfigure.xml");
//		//2、创建sqlSessionFactory
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
//		//3、创建SqlSession
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		//4、从sqlSession中获取Mapper接口的代理对象
//		AdminMapper userMapper = sqlSession.getMapper(AdminMapper.class);
//		//5、执行查询方法
//
//		List<Admin> u = (List<Admin>) userMapper.findAdmins();
//		
//		System.out.println(u);
//		
//		//5、事务提交
//		sqlSession.commit();
//		
//		//6、释放资源
//		sqlSession.close();
	}
}
