package com.library.management.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
    private String title;
    private String author;
    private String genre;
    private boolean isBorrowed;
    private String borrowedBy;
    private LocalDate dueDate;
}
