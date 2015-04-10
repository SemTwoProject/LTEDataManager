package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.dao.UserDAO;
import com.entity.User;
import com.interfaces.UserServiceLocal;

@Stateless
@Local
public class UserServiceEJB implements UserServiceLocal {
	
	@EJB
	private UserDAO dao;
	
	public void addToUserDatabase(User user){
			dao.addUser(user);
	}
	
	public Collection<User> getAllUsersInDatabase(){
		return dao.getAllUsers();
	}
	
	public User getUserByName(String name){
		return dao.getUserByName(name);
	}

	public Collection<User> getUserByUsernameAndPassword(String username, String password) {
		return dao.getUserByUsernameAndPassword(username, password);
	}
}