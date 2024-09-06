package com.library.management.persistence;

import com.library.management.dto.User;

public interface IUserManagerDao {
	public void addUser(String username, String password,String name, User.Role role);
	public User authenticate(String username, String password);
	public void removeUser(String username);
	public void createAdminAccount();
	public User findById(String username);
}
