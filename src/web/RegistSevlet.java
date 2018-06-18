package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.domain.User;

/**
 * Servlet implementation class RegistSevlet
 */
@WebServlet("/registSevlet")
@SuppressWarnings("all")

public class RegistSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("username");
		
			System.out.println(userName);
			String userPassword=request.getParameter("password");
			System.out.println(userPassword);
			String age=request.getParameter("age");
			System.out.println(age);
			String hobby = getString(request.getParameterValues("hobby"));
			User user=new User();
			user.setAge(Integer.parseInt(age));
			user.setHobby(hobby);
			user.setUserName(userName);
			user.setUserPassword(userPassword);
			QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDatesource());
			String getSql="select * from user where userName=?";
			int flag=0;
			try {
				  User existuser = queryRunner.query(getSql,new BeanHandler<User>(User.class), userName);
				 if(existuser!=null)
				 {
					 PrintWriter writer = response.getWriter();
					 writer.print("账户已存在");
				 }
				 else
				 {
			String sql="insert into user (userName,userPassword,age,hobby) values (?,?,?,?)";
			String [] para={user.getUserName(),user.getUserPassword(),Integer.toString(user.getAge()),user.getHobby()};
			response.setContentType("text/html;charset=utf-8");
		
			
				flag = queryRunner.update(sql,para);
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(flag!=0)
			{
				PrintWriter writer = response.getWriter();
			
				writer.print("注册成功");
			}
			else
			{
				PrintWriter writer = response.getWriter();
				
				writer.print("注册失败,请重新注册");
				response.sendRedirect("regist.html");
			}
	}
	public static String getString(String [] values)
	{
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<values.length;i++)
		{
			sb.append(" ").append(values[i]);
		}
		return sb.toString();
	}

}
