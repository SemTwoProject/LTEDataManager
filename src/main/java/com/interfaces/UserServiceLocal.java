package com.interfaces;

import java.util.Collection;

import com.entity.User;

public interface UserServiceLocal {
	
	void addToUserDatabase(User user);
	Collection<User> getAllUsersInDatabase();
	User getUserByName(String name);
	Collection<User> getUserByUsernameAndPassword(String username, String password);
}
