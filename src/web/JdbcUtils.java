package web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	public static Connection connection = null;
	public static DataSource getDatesource()
	{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		return dataSource;
	}
	public static Connection getConnection()
	{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
