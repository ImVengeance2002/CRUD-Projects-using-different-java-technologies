package com.library.management.service;

import java.util.Scanner;

import com.library.management.persistence.ILibraryDao;
import com.library.management.persistence.LibraryDaoImpl;

public class LibraryManagementServiceImpl implements ILibraryManagementService {
	
	private static Scanner scanner = new Scanner(System.in);
	private ILibraryDao dao= new LibraryDaoImpl();
	@Override
	public void addBook() {
		System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        dao.addBook(title, author, genre);
	}

	@Override
	public void viewBooks() {
		dao.viewBooks();
	}

	@Override
	public void updateBook() {
		System.out.print("Enter the ID of the book to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new title: ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter new author: ");
        String newAuthor = scanner.nextLine();
        System.out.print("Enter new genre: ");
        String newGenre = scanner.nextLine();
        dao.updateBook(id, newTitle, newAuthor, newGenre);
	}

	@Override
	public void deleteBook() {
		System.out.print("Enter the ID of the book to delete: ");
	    int id = scanner.nextInt();
	    scanner.nextLine();
	    dao.deleteBook(id);
	}

	@Override
	public void borrowBook() {
		// TODO Auto-generated method stub
		System.out.print("Enter the ID of the book to delete: ");
		int id = scanner.nextInt();
		dao.borrowBook(id);
	}

	@Override
	public void returnBook() {
		// TODO Auto-generated method stub
		System.out.print("Enter the ID of the book to delete: ");
		int id = scanner.nextInt();
		dao.returnBook(id);
	}

}
