package com.revaturee.service;

import com.revaturee.models.User;

public interface Authenticate {

	boolean authenticate(String username, String password);

	User getUser(String username);
	
	void createAccount(String username);

}
