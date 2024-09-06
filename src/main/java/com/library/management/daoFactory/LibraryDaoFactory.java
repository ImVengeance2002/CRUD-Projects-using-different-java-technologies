package com.library.management.daoFactory;


import com.library.management.persistence.ILibraryDao;
import com.library.management.persistence.LibraryDaoImpl;

public class LibraryDaoFactory {
	
	public static ILibraryDao libraryDao=null;
	private LibraryDaoFactory() {
		
	}
	public static ILibraryDao getLibraryDao(){
		if (libraryDao == null) {
			libraryDao= new LibraryDaoImpl();
		}
		return libraryDao;
	}
}
