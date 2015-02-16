package com.webservice;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.entity.User;
import com.interfaces.UserDAO;
import com.interfaces.UserService;

@Stateless
@Local
@TransactionAttribute (TransactionAttributeType.REQUIRED)
public class UserServiceEJB implements UserService {
	
	@Inject
	private UserDAO dao;
	
	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
	
	public void addToUserDatabase(User user){
		if(!dao.getAllUsers().contains(user))
			dao.addUser(user);
	}
	
	public Collection<User> getAllUsersInDatabase(){
		return dao.getAllUsers();
	}

	public Collection<User> checkLoginDetails() {
		return dao.getUserByUsernameAndPassword();
	}
}