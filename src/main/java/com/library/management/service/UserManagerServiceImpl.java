package com.library.management.service;

import java.util.Scanner;

import com.library.management.daoFactory.UserDaoFactory;
import com.library.management.dto.User;
import com.library.management.dto.User.Role;
import com.library.management.persistence.IUserManagerDao;

public class UserManagerServiceImpl implements IUserManagerService {

	private IUserManagerDao userDao=null;
	private static Scanner scanner=null;
	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		userDao=UserDaoFactory.getUserManagerDAO();
		if (userDao != null) {
			System.out.println("Enter the username");
			String username=scanner.nextLine();
			System.out.println("Enter the password");
			String password=scanner.nextLine();
			System.out.println("Enter the name");
			String name=scanner.nextLine();
			System.out.println("Enter 1 for creating librarian account and 2 for member account");
			int role=scanner.nextInt();
			User user = userDao.findById(username.toLowerCase());
			if (user == null) {
				if (role==1) {
					userDao.addUser(username, password,name, Role.LIBRARIAN);
				}else if(role==2) {
					userDao.addUser(username, password,name, Role.MEMBER);
				}else {
					System.out.println("Wrong inputs");
				}
			}
			else {
				System.out.println("Username alreadry present fot the user name "+user.getName()+" having "+user.getRole()+" privilleges.");
			}
		}		
	}

	@Override
	public User authenticate(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("UserManagerServiceImpl.authenticate()");
		userDao=UserDaoFactory.getUserManagerDAO();
		if (userDao != null) {
			User user = userDao.findById(username);
			if (user.getPassword().equals(password)) {
				System.out.println("Welcome! "+user.getName());
				return user;
			} else {
				System.out.println("Incorrect credentials");
			}
		}
		return null;
	}

	@Override
	public void removeUser() {
		// TODO Auto-generated method stub
		userDao=UserDaoFactory.getUserManagerDAO();
		if (userDao != null) {
			System.out.println("Enter the username");
			String username=scanner.nextLine();
			User findById = userDao.findById(username);
			System.out.println("Are you sure you want to delete the user named : "+findById.getName()+".Press y to delete");
			char ch=scanner.nextLine().charAt(0);
			if (ch=='y'||ch=='Y') {
				userDao.removeUser(username);
			}
		}
	}

}
