package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.dao.UserDAO;
import com.entity.User;
import com.interfaces.UserService;

@Stateless
@Local
public class UserServiceEJB implements UserService {
	
	@EJB
	private UserDAO dao;
	
	public void addToUserDatabase(User user){
			dao.addUser(user);
	}
	
	public Collection<User> getAllUsersInDatabase(){
		return dao.getAllUsers();
	}

	public User checkLoginDetails(String username,String password) {
		return dao.getUserByUsernameAndPassword(username,password);
	}
	
	public User getUserByName(String name){
		return dao.getUserByName(name);
	}
}