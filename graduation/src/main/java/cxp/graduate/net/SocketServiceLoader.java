package cxp.graduate.net;

import static org.hamcrest.CoreMatchers.nullValue;

import java.net.ServerSocket;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SocketServiceLoader implements ServletContextListener {

	private SocketThread socketThread;
	/**
	 * 初始化服务器线程
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext servletContext = sce.getServletContext();
		String str = (String) servletContext.getAttribute("SocketThreadRun");//获取字段（是否存在）
		if(socketThread == null && str ==null) {
			servletContext.setAttribute("SocketThreadRun", "true");
			socketThread = new SocketThread(null,servletContext);
			Thread thread = new Thread(socketThread);
			thread.start();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}
}
