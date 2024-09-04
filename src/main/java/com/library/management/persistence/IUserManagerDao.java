package com.library.management.persistence;

import com.library.management.dto.User;

public interface IUserManagerDao {
	public void addUser(String username, String password, User.Role role);
	public User authenticate(String username, String password);
	public void createAdminAccount();
	public void saveUsersToFile();
}
