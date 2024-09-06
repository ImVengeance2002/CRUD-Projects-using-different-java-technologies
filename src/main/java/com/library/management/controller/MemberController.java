package com.library.management.controller;

import java.util.Scanner;

import com.library.management.dto.User;
import com.library.management.service.ILibraryManagementService;
import com.library.management.serviceFactory.LibraryServiceFactory;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class MemberController {
	@NonNull
	private User currentUser;
	private ILibraryManagementService library = null;
	
	public void showMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome "+currentUser.getName());
		System.out.println("Account role --> "+currentUser.getRole());
        System.out.println("1. View All Books");
        System.out.println("2. Borrow Book");
        System.out.println("3. Return Book");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
        int choice=scanner.nextInt();
        scanner.close();
        processChoice(choice);
	}
	public void processChoice(int choice) {
		library=LibraryServiceFactory.getLibraryService();
		boolean running = true;
			while (running) {           
            switch (choice) {
                case 1:
                    library.viewBooks();
                    break;
                case 2:
                    library.borrowBook();
                    break;
                case 3:
                    library.returnBook();
                    break;
                case 4:
                	  running=false;
                	break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
	}
}
