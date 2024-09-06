package com.library.management.daoFactory;

import com.library.management.persistence.IUserManagerDao;
import com.library.management.persistence.UserManagerDao;

public class UserDaoFactory {
public static IUserManagerDao userDao=null;
	
	private UserDaoFactory() {
		
	}
	
	public static IUserManagerDao getUserManagerDAO()
	{
		if (userDao == null) {
			userDao=new UserManagerDao();
		}
		return userDao;
	}
}
