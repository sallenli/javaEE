package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.domain.User;

/**
 * Servlet implementation class RegistServletUpdate
 */
@WebServlet("/registServletUpdate")
public class RegistServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			User user=new User();
			BeanUtils.populate(user, request.getParameterMap());
			String hobby =RegistSevlet.getString( request.getParameterValues("hobby"));
			user.setHobby(hobby);
			String check="select * from user where userName=?";
			int flag=0;
			QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDatesource());
			User existuser = queryRunner.query(check, new BeanHandler<User>(User.class),request.getParameter("username"));
			response.setContentType("text/html;charset=utf-8");
			if(existuser!=null)
			{
				PrintWriter writer = response.getWriter();
				writer.print("账户已存在");
			}
			else
			{
			String sql="insert into user (userName,userPassword,age,hobby) values (?,?,?,?)";
			String[]	para={user.getUserName(),user.getUserPassword(),Integer.toString(user.getAge()),user.getHobby()};
				queryRunner.update(sql,para);
				PrintWriter writer = response.getWriter();
		
				writer.print("注册成功");
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
	}

}
