package com.library.management.controller;

import java.util.Scanner;

import com.library.management.dto.User;
import com.library.management.service.ILibraryManagementService;
import com.library.management.service.LibraryManagementServiceImpl;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class LibrarianController {
	private User currentUser;
	
	public void showMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome "+currentUser.getName());
		System.out.println("Account role --> "+currentUser.getRole());
        System.out.println("1. Add Book");
        System.out.println("2. View All Books");
        System.out.println("3. Update Book");
        System.out.println("4. Delete Book");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
        int choice=scanner.nextInt();
        scanner.close();
        processChoice(choice);
	}
	public void processChoice(int choice) {
		ILibraryManagementService library = new LibraryManagementServiceImpl();
		boolean running = true;
			while (running) {           
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
                	  running=false;
                	break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
	}
}
