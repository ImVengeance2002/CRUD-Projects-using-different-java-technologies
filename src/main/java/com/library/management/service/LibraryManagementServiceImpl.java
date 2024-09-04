package com.library.management.service;

import java.util.Scanner;

public class LibraryManagementServiceImpl implements ILibraryManagementService {
	
	private static Scanner scanner = new Scanner(System.in);
	@Override
	public void addBook() {
		// TODO Auto-generated method stub
		System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
	}

	@Override
	public void viewBooks() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBook() {
		// TODO Auto-generated method stub
		System.out.print("Enter the ID of the book to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new title: ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter new author: ");
        String newAuthor = scanner.nextLine();
        System.out.print("Enter new genre: ");
        String newGenre = scanner.nextLine();
	}

	@Override
	public void deleteBook() {
		// TODO Auto-generated method stub
		 System.out.print("Enter the ID of the book to delete: ");
	        int id = scanner.nextInt();
	        scanner.nextLine(); // Consume newline
	}

}
