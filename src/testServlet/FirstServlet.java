package testServlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	 @Override

	    public void destroy() {

	        //TODO Auto-generated method stub

	        System.out.println("-----servlet被销毁 该方法会执行----");

	    }
	    @Override

	    public ServletConfig getServletConfig() {

	        //TODO Auto-generated method stub

	        return null;

	    }

	    @Override
	    public String getServletInfo() {

	        //TODO Auto-generated method stub

	        return null;

	    }
		@Override
		public void init(ServletConfig arg0) throws ServletException {
			// TODO Auto-generated method stub
			   //   Servlet对象 tomcat服务器在接受客户端发送请求  对象被创建

	        System.out.println("-----servlet被创建 该方法会执行----");
		}
		@Override
		public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
			// TODO Auto-generated method stub
			  // 每发送一次请求 该方法执行一次...
	        System.out.println("-----接受一次请求----");
		}
	    
}
