package com.library.management.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int book_id;
    private String title;
    private String author;
    private String genre;
    private String isbn;
    private String publisher;
    private int year_published;
    private int copies_available;
    private boolean isBorrowed;
    private User borrowedBy;
    private LocalDate dueDate;
}
