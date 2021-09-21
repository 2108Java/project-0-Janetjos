package com.revaturee.models;

import java.util.List;

public class User {

	private String username;
	
	private String password;
		
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		
	}

	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


//May require to create this method in the customer model
	public void setCustomerDetails(boolean status) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
