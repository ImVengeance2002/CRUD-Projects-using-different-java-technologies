package com.library.management.controller;

import java.util.Scanner;

import com.library.management.dto.User;
import com.library.management.service.ILibraryManagementService;
import com.library.management.service.IUserManagerService;
import com.library.management.service.LibraryManagementServiceImpl;
import com.library.management.service.UserManagerServiceImpl;

public class Controller {
	
	private static ILibraryManagementService library = new LibraryManagementServiceImpl();
    private static IUserManagerService userManager =new UserManagerServiceImpl();
    private static Scanner scanner = new Scanner(System.in);
	private static User currentUser;
	
	public static void login() {
		printAdminMenu();
	}
	public static void printAdminMenu() {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Add Book");
        System.out.println("2. View All Books");
        System.out.println("3. Update Book");
        System.out.println("4. Delete Book");

        if (currentUser.getRole() == User.Role.ADMIN) {
            System.out.println("5. Add User");
        }

        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }
	public static void processChoice() {
		boolean running = true;
			while (running) {
        	
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    library.addBook();
                    break;
                case 2:
                    library.viewBooks();
                    break;
                case 3:
                    library.updateBook();
                    break;
                case 4:
                    library.deleteBook();
                    break;
                case 5:
                    userManager.addUser();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
	}
	public static void printUserMenu() {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Add Book");
        System.out.println("2. View All Books");
        System.out.println("3. Update Book");
        System.out.println("4. Delete Book");

        if (currentUser.getRole() == User.Role.ADMIN) {
            System.out.println("5. Add User");
        }

        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }
}
