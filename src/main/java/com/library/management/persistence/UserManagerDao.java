package com.library.management.persistence;

import com.library.management.dto.User;
import com.library.management.dto.User.Role;

public class UserManagerDao implements IUserManagerDao {

	@Override
	public void addUser(String username, String password, Role role) {
		// TODO Auto-generated method stub

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
	public void saveUsersToFile() {
		// TODO Auto-generated method stub

	}

}
