package com.revaturee.repo;

import com.revaturee.models.User;

public interface UserDao {

	User selectUserByUsername(String username);

}
