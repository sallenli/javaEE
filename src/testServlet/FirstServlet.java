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

	        System.out.println("-----servlet������ �÷�����ִ��----");

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
			   //   Servlet���� tomcat�������ڽ��ܿͻ��˷�������  ���󱻴���

	        System.out.println("-----servlet������ �÷�����ִ��----");
		}
		@Override
		public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
			// TODO Auto-generated method stub
			  // ÿ����һ������ �÷���ִ��һ��...
	        System.out.println("-----����һ������----");
		}
	    
}
