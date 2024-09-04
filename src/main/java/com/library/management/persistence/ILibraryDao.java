package com.library.management.persistence;

import java.util.List;

import com.library.management.dto.Book;

public interface ILibraryDao {

	public void addBook(String title, String author, String genre);
	public void viewBooks();
	public void updateBook(int id, String newTitle, String newAuthor, String newGenre);
	public void deleteBook(int id);
	public void saveBooksToFile();
	public List<Book> loadBooksFromFile();
}
