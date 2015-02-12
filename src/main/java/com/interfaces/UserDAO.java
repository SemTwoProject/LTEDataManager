package com.interfaces;

import java.util.Collection;

import com.entity.User;

public interface UserDAO {

	void addUser(User user);
	Collection<User> getAllUsers();

}


