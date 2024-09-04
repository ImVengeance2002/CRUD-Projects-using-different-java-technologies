package com.library.management.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {

		private static final long serialVersionUID = 1L;
		
		private String username;
	    private String password;
	    private Role role;

	    public enum Role {
	        ADMIN, LIBRARIAN, MEMBER
	    }
}
