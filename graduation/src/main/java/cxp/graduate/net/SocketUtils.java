package cxp.graduate.net;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * @ClassName:  SocketUtils   
 * @Description:按照网上的例子 
 * @date:   2018年11月23日 下午3:29:31
 */
public class SocketUtils implements ApplicationContextAware{
	
	private static ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
	}
	 /**
	  * 获取applicationContext对象
	  * @return
	  */
	public static ApplicationContext getApplicationContext() {
	     return applicationContext;
	}
	 
	 
   /**
    * 根据bean的id来查找对象
    * @param id
    * @return
    */
	 
	public static <T> T getBeanByName(String name) {
		return (T) applicationContext.getBean(name);
	}
   /**
    * 根据bean的class来查找对象
    * @param c
    * @return
    */
	public static <T> T getBeanByClass(Class c) {
	    return (T) applicationContext.getBean(c);
	}

 
   /**
    * 根据bean的class来查找所有的对象(包括子类)
	* @param c
	* @return
   */
	public static Map getBeansByClass(Class c) {
		return applicationContext.getBeansOfType(c);
	}

	 public static String getMessage(String key) {
		 return applicationContext.getMessage(key, null, Locale.getDefault());
	 }
	
}
