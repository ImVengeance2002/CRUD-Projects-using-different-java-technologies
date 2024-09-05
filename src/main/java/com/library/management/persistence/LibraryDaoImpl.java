package com.library.management.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.library.management.util.JdbcUtil;

public class LibraryDaoImpl implements ILibraryDao {
	
	private Connection connection=null;
	private PreparedStatement pstmt=null;
	private ResultSet resultSet=null;
	
	@Override
	public void addBook(String title, String author, String genre,String isbn,String publisher,int year_published,int copies_available) {
		// TODO Auto-generated method stub
		String insertQuery="insert into books(`title`,`author`,`genre`)values(?,?,?)";
		 
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
	public void viewBooks() {
		// TODO Auto-generated method stub
		String selectQuery="select * from library";
		try {
			connection=JdbcUtil.getConnection();
			if (connection != null) {
				pstmt=connection.prepareStatement(selectQuery);
				if (pstmt != null) {
					resultSet = pstmt.executeQuery();
					if (resultSet != null) {
						System.out.println("");
						while (resultSet.next()) {
							System.out.println(resultSet.getString(1)+""+resultSet.getString(2));
						}
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
	public void updateBook(int id, String newTitle, String newAuthor, String newGenre) {
		// TODO Auto-generated method stub
		String updateQuery="";
		try {
			connection=JdbcUtil.getConnection();
			if (connection != null) {
				pstmt=connection.prepareStatement(updateQuery);
				if (pstmt != null) {
					pstmt.setInt(4, id);
					pstmt.setString(1, newTitle);
					pstmt.setString(2, newAuthor);
					pstmt.setString(3, newGenre);
					int count = pstmt.executeUpdate();
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
		String deleteQuery="";
		try {
			connection=JdbcUtil.getConnection();
			if (connection != null) {
				pstmt=connection.prepareStatement(deleteQuery);
				if (pstmt != null) {
					pstmt.setInt(1, id);
					int count = pstmt.executeUpdate();
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
		String updateQuery="";
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
		String updateQuery="";
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
}
