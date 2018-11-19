package cxp.graduate.net;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cxp.graduate.net.SocketThread;

public class SocketServiceLoader implements ServletContextListener {

	private SocketThread socketThread;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		ServletContext servletContext = arg0.getServletContext();
		String str = (String) servletContext.getAttribute("SocketThreadRun");//获取字段（是否存在）
		if(socketThread == null && str ==null) {
			servletContext.setAttribute("SocketThreadRun", "true");
			socketThread = new SocketThread(null,servletContext);
			Thread thread = new Thread(socketThread);
			thread.start();
		}
	}
}
