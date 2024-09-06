package com.library.management.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.management.dto.User;
import com.library.management.dto.User.Role;
import com.library.management.util.JdbcUtil;

public class UserManagerDao implements IUserManagerDao {
	private Connection connection=null;
	private PreparedStatement pstmt=null;
	private ResultSet resultSet=null;
	@Override
	public void addUser(String username, String password,String name, Role role) {
		// TODO Auto-generated method stub
		String add="insert into books(`username`,`password`,`name`,`role`) values(?,?,?,?) ";
		try {
			connection=JdbcUtil.getConnection();
			if (connection != null) {
				pstmt=connection.prepareStatement(add);
				if (pstmt != null) {
					pstmt.setString(1, username);
					pstmt.setString(2, password);
					pstmt.setString(3, name);
					pstmt.setString(4, role.name());
					int count = pstmt.executeUpdate();
					if (count!=0) {
						System.out.println("Welcome to library "+name+" you are now a "+role.name());
					}
					else {
						System.out.println("There was an error in registering a new user");
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User authenticate(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createAdminAccount() {
		// TODO Auto-generated method stub

	}

	@Override
	public User findById(String username) {
		// TODO Auto-generated method stub
		String search="select * from users where username=?";
		User user=null;
		try {
			connection=JdbcUtil.getConnection();
			if (connection != null) {
				pstmt=connection.prepareStatement(search);
				if (pstmt != null) {
					pstmt.setString(1, username);
					resultSet = pstmt.executeQuery();
					if (resultSet != null) {
						resultSet.next();
						user=new User();
						user.setUsername(resultSet.getString(1));
						user.setPassword(resultSet.getString(2));
						user.setName(resultSet.getString(3));
						user.setRole(Role.valueOf(resultSet.getString(4)));
						return user;
					}
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void removeUser(String username) {
		// TODO Auto-generated method stub
		String delete="delete from users where username=?";
		try {
			connection=JdbcUtil.getConnection();
			if (connection != null) {
				pstmt=connection.prepareStatement(delete);
				if (pstmt != null) {
					pstmt.setString(1, username);
					int count = pstmt.executeUpdate();
					if (count!=0) {
						System.out.println("The account successfully got deleted");
					}
					else {
						System.out.println("Error encountered during deleting the user named "+username);
					}
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
