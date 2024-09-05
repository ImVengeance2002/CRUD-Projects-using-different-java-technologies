package com.library.management.service;

import com.library.management.dto.User;

public interface IUserManagerService {
	public void addUser();
	public void removeUser();
	public User authenticate(String username,String password);
}
