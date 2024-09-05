package com.library.management.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws IOException, SQLException {
		FileInputStream fis= new FileInputStream("");
		Properties properties=new Properties();
		properties.load(fis);
		
		Connection connection=DriverManager.getConnection("", properties);
		fis.close();
		return connection;
	}
	
	public void cleanUp(Connection con, Statement statement, ResultSet resultSet) throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (con != null) {
			con.close();
		}
	}
}
