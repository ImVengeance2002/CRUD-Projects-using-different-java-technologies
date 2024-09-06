package com.library.management.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.library.management.dto.Book;
import com.library.management.util.JdbcUtil;

public class LibraryDaoImpl implements ILibraryDao {
	
	private Connection connection=null;
	private PreparedStatement pstmt=null;
	private ResultSet resultSet=null;
	
	@Override
	public String addBook(String title, String author, String genre,String isbn,String publisher,int year_published,int copies_available) {
		// TODO Auto-generated method stub
		String insertQuery="insert into books(`title`,`author`,`genre`,`isbn`,`publisher`,`year_published`,`copies_available`) values(?,?,?,?,?,?,?) ";
		 
			try {
				connection=JdbcUtil.getConnection();
				if (connection != null) {
					pstmt=connection.prepareStatement(insertQuery);
					if (pstmt != null) {
						pstmt=connection.prepareStatement("insert into books(`title`,`author`,`genre`,`isbn`,`publisher`,`year_published`,`copies_available`) values(?,?,?,?,?,?,?) ");
						pstmt.setString(1, title);
						pstmt.setString(2, author);
						pstmt.setString(3, genre);
						pstmt.setString(4, isbn);
						pstmt.setString(5, publisher);
						pstmt.setInt(6, year_published);
						pstmt.setInt(7, copies_available);	
						int row=pstmt.executeUpdate();
						if (row!=0) {							
							return "The book is added to the library";
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "There was an error in adding the book to the library";
	}

	@Override
	public List<Book> viewBooks() {
		// TODO Auto-generated method stub
		String selectQuery="select * from library";
		List<Book> list = new ArrayList<Book>();
		Book book=null;
		try {
			connection=JdbcUtil.getConnection();
			if (connection != null) {
				pstmt=connection.prepareStatement(selectQuery);
				if (pstmt != null) {
					resultSet = pstmt.executeQuery();
					if (resultSet != null) {
						while (resultSet.next()) {
							book=new Book();
							book.setBook_id(resultSet.getInt(1));
							book.setTitle(resultSet.getString(2));
							book.setAuthor(resultSet.getString(3));
							book.setGenre(resultSet.getString(4));
							book.setIsbn(resultSet.getString(5));
							book.setPublisher(resultSet.getString(6));
							book.setYear_published(resultSet.getInt(7));
							book.setCopies_available(resultSet.getInt(8));
							list.add(book);
						}
					}
				}
				return list;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateBook(int id,String title, String author, String genre,String isbn,String publisher,int year_published,int copies_available) {
		// TODO Auto-generated method stub
		String updateQuery="update books title=?,author=?,genre=?,isbn=?,publisher=?,year_published=?,copies_available=? where book_id=?";
		try {
			connection=JdbcUtil.getConnection();
			if (connection != null) {
				pstmt=connection.prepareStatement(updateQuery);
				if (pstmt != null) {
					pstmt.setString(1,title);
					pstmt.setString(2, author);
					pstmt.setString(3, genre);
					pstmt.setString(4, isbn);
					pstmt.setString(5, publisher);
					pstmt.setInt(6, year_published);
					pstmt.setInt(7, copies_available);
					pstmt.setInt(8, id);
					int count = pstmt.executeUpdate();
					if (count != 0) {
						System.out.println("Book Updated");
					}
					else {
						System.out.println("There was an error in updating the book details.");
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		String deleteQuery="delete from library.books where book_id=?";
		try {
			connection=JdbcUtil.getConnection();
			if (connection != null) {
				pstmt=connection.prepareStatement(deleteQuery);
				if (pstmt != null) {
					pstmt.setInt(1, id);
					int count = pstmt.executeUpdate();
					if (count!=0) {
						System.out.println("Book successfully removed from the library");
					} else {
						System.out.println("Error in removing the book from the library");
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int borrowBook(int id) {
		String updateQuery="update library.books set copies_available=copies_available+1 where book_id=?";
		try {
			connection=JdbcUtil.getConnection();
			if (connection != null) {
				pstmt=connection.prepareStatement(updateQuery);
				if (pstmt != null) {
					pstmt.setInt(1, id);
					int count = pstmt.executeUpdate();
					return count;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int returnBook(int id) {
		// TODO Auto-generated method stub
		String updateQuery="update library.books set copies_available=copies_available-1 where book_id=?";
		try {
			connection=JdbcUtil.getConnection();
			if (connection != null) {
				pstmt=connection.prepareStatement(updateQuery);
				if (pstmt != null) {
					pstmt.setInt(1, id);
					int count = pstmt.executeUpdate();
					return count;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Book findBookById(int id) {
		String findById="SELECT * FROM library.books where book_id=?";
		Book book=null;
		try {
			connection=JdbcUtil.getConnection();
			if (connection != null) {
				pstmt=connection.prepareStatement(findById);
				if (pstmt != null) {
					pstmt.setInt(1, id);
					resultSet=pstmt.executeQuery();
					if (resultSet != null) {
						resultSet.next();
						book=new Book();
						book.setBook_id(id);
						book.setTitle(resultSet.getString(1));
						book.setAuthor(resultSet.getString(2));
						book.setGenre(resultSet.getString(3));
						book.setIsbn(resultSet.getString(4));
						book.setPublisher(resultSet.getString(5));
						book.setYear_published(resultSet.getInt(6));
						book.setCopies_available(resultSet.getInt(7));
						return book;
					}		
				}
			}
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
