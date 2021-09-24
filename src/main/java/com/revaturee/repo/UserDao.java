package com.revaturee.repo;

import com.revaturee.models.User;

public interface UserDao {
	
	boolean insertUser(User u);

	User selectUserByUsername(String username);

}
