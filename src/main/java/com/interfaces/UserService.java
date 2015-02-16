package com.interfaces;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.User;

@Local
public interface UserService {
	
	void addToUserDatabase(User user);
	Collection<User> getAllUsersInDatabase();
	Collection<User> checkLoginDetails();
}
