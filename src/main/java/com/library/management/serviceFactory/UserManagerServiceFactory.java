package com.library.management.serviceFactory;


import com.library.management.service.IUserManagerService;
import com.library.management.service.UserManagerServiceImpl;

public class UserManagerServiceFactory {

	private static IUserManagerService userManagerService=null;
	private UserManagerServiceFactory() {
		
	}
	public static IUserManagerService getUserManagerService() {
		if (userManagerService == null) {
			userManagerService=new UserManagerServiceImpl();
		}
		return userManagerService;
	}
}
