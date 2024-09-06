package com.library.management.service;

import java.util.List;
import java.util.Scanner;

import com.library.management.daoFactory.LibraryDaoFactory;
import com.library.management.dto.Book;
import com.library.management.persistence.ILibraryDao;

public class LibraryManagementServiceImpl implements ILibraryManagementService {
	
	private static Scanner scanner = new Scanner(System.in);
	private ILibraryDao dao=null;
	@Override
	public void addBook() {
		dao=LibraryDaoFactory.getLibraryDao();
		if (dao != null) {
			System.out.print("Enter title: ");
	        String title = scanner.nextLine();
	        System.out.print("Enter author: ");
	        String author = scanner.nextLine();
	        System.out.print("Enter genre: ");
	        String genre = scanner.nextLine();
	        System.out.print("Enter isbn: ");
	        String isbn=scanner.nextLine();
	        System.out.print("Enter publisher: ");
	        String publisher=scanner.nextLine();
	        System.out.print("Enter year published: ");
	        int year_published=scanner.nextInt();
	        System.out.print("Enter number of copies available: ");
	        int copies_available=scanner.nextInt();
	        System.out.println(dao.addBook(title,author,genre,isbn,publisher,year_published,copies_available));
		}
	}

	@Override
	public void viewBooks() {
		dao=LibraryDaoFactory.getLibraryDao();
		if (dao != null) {			
			List<Book> list = dao.viewBooks();
			if (list != null) {
				list.forEach(System.out::println);
			}
			System.out.println("There was an error in fetching the record");
		}
	}

	@Override
	public void updateBook() {
		dao=LibraryDaoFactory.getLibraryDao();
		if (dao != null) {
			System.out.print("Enter the ID of the book to update: ");
	        int id = scanner.nextInt();
	        scanner.nextLine();
	        System.out.print("Enter new title: ");
	        String title = scanner.nextLine();
	        System.out.print("Enter new author: ");
	        String author = scanner.nextLine();
	        System.out.print("Enter new genre: ");
	        String genre = scanner.nextLine();
	        System.out.print("Enter new isbn: ");
	        String isbn=scanner.nextLine();
	        System.out.print("Enter new publisher: ");
	        String publisher=scanner.nextLine();
	        System.out.print("Enter new year published: ");
	        int year_published=scanner.nextInt();
	        System.out.print("Enter new number of copies available: ");
	        int copies_available=scanner.nextInt();
	        dao.updateBook(id,title,author,genre,isbn,publisher,year_published,copies_available);
	        System.out.println("*************************");
	        System.out.println("The new details of the book is :");
	        System.out.println(dao.findBookById(id));       
		}
	}

	@Override
	public void deleteBook() {
		dao=LibraryDaoFactory.getLibraryDao();
		if (dao != null) {
			System.out.print("Enter the ID of the book to delete: ");
		    int id = scanner.nextInt();
		    scanner.nextLine();
		    Book findBookById = dao.findBookById(id);
		    if (findBookById != null) {
		    	System.out.println("Title :\t"+findBookById.getTitle());				
				System.out.println("Author :\t"+findBookById.getAuthor());
				System.out.println("Genre :\t"+findBookById.getGenre());
				System.out.println("Isbn :\t"+findBookById.getIsbn());
				System.out.println("Publisher :\t"+findBookById.getPublisher());
				System.out.println("Year Published :\t"+findBookById.getYear_published());
				System.out.println("Year Published :\t"+findBookById.getYear_published());
				System.out.println("Are you sure you want to delete this entry. Y/N");
				char ch=scanner.nextLine().charAt(0);
				if (ch=='y'||ch=='Y') {
					dao.deleteBook(id);
				}		
			}
		}
	}

	@Override
	public void borrowBook() {
		// TODO Auto-generated method stub
		dao=LibraryDaoFactory.getLibraryDao();
		if (dao != null) {
			System.out.print("Enter the ID of the book to borrow: ");
		    int id = scanner.nextInt();
		    scanner.nextLine();
		    Book findBookById = dao.findBookById(id);
		    if (findBookById != null && findBookById.getCopies_available()>0) {
		    	System.out.println("Title :\t"+findBookById.getTitle());				
				System.out.println("Author :\t"+findBookById.getAuthor());
				System.out.println("Genre :\t"+findBookById.getGenre());
				System.out.println("Isbn :\t"+findBookById.getIsbn());
				System.out.println("Publisher :\t"+findBookById.getPublisher());
				System.out.println("Year Published :\t"+findBookById.getYear_published());
				System.out.println("Year Published :\t"+findBookById.getYear_published());
				System.out.println("Are you sure you want to borrow this book. Y/N");
				char ch=scanner.nextLine().charAt(0);
				if (ch=='y'||ch=='Y') {
					dao.borrowBook(id);
				}		
			}
		    else {
		    	System.out.println("No more copies of this book is available in the library");
		    }
		}
	}

	@Override
	public void returnBook() {
		// TODO Auto-generated method stub
		dao=LibraryDaoFactory.getLibraryDao();
		if (dao != null) {
			System.out.print("Enter the ID of the book to return: ");
		    int id = scanner.nextInt();
		    scanner.nextLine();
		    Book findBookById = dao.findBookById(id);
		    if (findBookById != null) {
		    	System.out.println("Title :\t"+findBookById.getTitle());				
				System.out.println("Author :\t"+findBookById.getAuthor());
				System.out.println("Genre :\t"+findBookById.getGenre());
				System.out.println("Isbn :\t"+findBookById.getIsbn());
				System.out.println("Publisher :\t"+findBookById.getPublisher());
				System.out.println("Year Published :\t"+findBookById.getYear_published());
				System.out.println("Year Published :\t"+findBookById.getYear_published());
				System.out.println("Are you sure you want to return this book. Y/N");
				char ch=scanner.nextLine().charAt(0);
				if (ch=='y'||ch=='Y') {
					dao.returnBook(id);
				}		
			}
		    else {
		    	System.out.println("The book was not borrowed from this library");
		    }
		}
	}

}
