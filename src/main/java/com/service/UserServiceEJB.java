package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
<<<<<<< HEAD
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.UserDAO;
import com.entity.User;
import com.serviceInterfaces.UserService;

@Stateless
@Local
@TransactionAttribute (TransactionAttributeType.REQUIRED)
=======

import com.dao.UserDAO;
import com.entity.User;
import com.interfaces.UserService;

@Stateless
@Local
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
public class UserServiceEJB implements UserService {
	
	@EJB
	private UserDAO dao;
	
<<<<<<< HEAD
	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
	
=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
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