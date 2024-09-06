package com.library.management.serviceFactory;

import com.library.management.service.ILibraryManagementService;
import com.library.management.service.LibraryManagementServiceImpl;

public class LibraryServiceFactory {

	public static ILibraryManagementService libraryService=null;
	private LibraryServiceFactory() {
		
	}
	public static ILibraryManagementService getLibraryService() {
		if (libraryService == null) {
			libraryService=new LibraryManagementServiceImpl();
		}
		return libraryService;
	}
	
}
