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
	public static Connection connection=null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws IOException, SQLException {
		if (connection == null) {
			FileInputStream fis= new FileInputStream("src/main/java/com/library/management/configuration/application.properties");
			Properties properties=new Properties();
			properties.load(fis);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/library", properties);
			fis.close();
		}
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
