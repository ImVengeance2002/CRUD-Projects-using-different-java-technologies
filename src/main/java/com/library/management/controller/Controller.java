package com.library.management.controller;

import java.util.Scanner;

import com.library.management.dto.User;
import com.library.management.service.IUserManagerService;
import com.library.management.serviceFactory.UserManagerServiceFactory;

public class Controller {
	
    private static IUserManagerService userManager =null;
    private static Scanner scanner = new Scanner(System.in);
	private static User currentUser;
	
	public static void login() {
		boolean running=true;
		userManager=UserManagerServiceFactory.getUserManagerService();
		while (running) {
			System.out.println("\nLibrary Management System");
			System.out.println("*************************");
			System.out.println("Enter Username");
			String username=scanner.nextLine();
			System.out.println("Enter Password");
			String password=scanner.nextLine();
			System.out.println("Enter Password");
			currentUser = userManager.authenticate(username, password);
			if (currentUser != null) {
				System.out.println(currentUser.getRole().name());
				if (currentUser.getRole()==User.Role.ADMIN) {
					AdminController admin=new AdminController(currentUser);
					admin.showMenu();
				}
				if (currentUser.getRole()==User.Role.LIBRARIAN) {
					LibrarianController librarian = new LibrarianController(currentUser);
					librarian.showMenu();
				}
				if (currentUser.getRole()==User.Role.MEMBER) {
					MemberController member = new MemberController(currentUser);
					member.showMenu();
				}
				running=false;
			}
			else {
				System.out.println("Invalid Credentials");
			}
			
		}
	}
}
