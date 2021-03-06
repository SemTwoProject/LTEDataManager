package com.dao;

import java.util.Collection;

import com.entity.User;

public interface UserDAO {

	void addUser(User user);
	Collection<User> getAllUsers();
	Collection<User> getUserByUsernameAndPassword(String username,String password);
	User getUserByName(String name);
}


