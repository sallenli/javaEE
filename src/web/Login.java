package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.domain.*;
/**
 * Servlet implementation class Login
 */
//@WebServlet(description = "登陆界面", urlPatterns = { "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String username=request.getParameter("username");
		String userpassword=request.getParameter("userpassword");
		String check = (String)request.getParameter("code");
		String checkSession = (String)request.getSession().getAttribute("code");
		
		if(check.equalsIgnoreCase(checkSession)&&check!=null)
		{
			
		if(username==null||userpassword==null)
		{
			System.out.println("账户密码不能为空");
			return;
		}
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDatesource());
		String sql="select * from User where userName=? and userPassword=?";
		try {
		User existUser=	queryRunner.query(sql, new BeanHandler<User>(User.class),username,userpassword);
		if(existUser==null)
		{
			System.out.println("用户不存在");
			PrintWriter writer = response.getWriter();
			writer.print("用户不存在");
			return;
		}
		else
		{
		PrintWriter writer = response.getWriter();
		writer.print("登陆成功");
			//response.sendRedirect("loginCorrect.html");
		//	System.out.println("登陆成功");
			Cookie [] cookies=request.getCookies();
			String cookieName="remember";
			Cookie cookie=findcookieByName(cookieName,cookies);
			
				long time=System.currentTimeMillis();
				if(cookie==null) //第一次登陆
				{
						writer.print("第一次登陆"+"\n");
						writer.print("登陆时间为:"+new Time(time));
						Cookie newcookie=new Cookie("remember", new Time(time).toString());
						newcookie.setPath("/");
						newcookie.setMaxAge(3600*24*30);
						
						
				response.addCookie(newcookie);
		}
				else
				{
					writer.print("不是第一次登陆"+"\n");
					writer.print("上次登陆时间为:"+cookie.getValue());
					cookie.setValue(new Time(time).toString());
					}
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else
		{
			PrintWriter writer = response.getWriter();
			writer.print("验证码输入错误");
		}
	}
	public static Cookie findcookieByName(String name,Cookie[] cookies)
	{
		for(Cookie cookie:cookies)
		{
			if(cookie.getName().equalsIgnoreCase(name))
			{
				return cookie;
			}
			
		}
	
		return null;
		
	}

}
