package com.interfaces;

import java.util.Collection;

import com.entity.User;

public interface UserServiceLocal {
	
	void addToUserDatabase(User user);
	Collection<User> getAllUsersInDatabase();
	User checkLoginDetails(String username,String password);
	User getUserByName(String name);
}
