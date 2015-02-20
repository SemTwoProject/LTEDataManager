package com.dao;

import java.util.Collection;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entity.User;
import com.interfaces.UserDAO;

@Default
public class JPAUserDAO implements UserDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public Collection<User> getAllUsers() {
		Query query = em.createQuery("FROM com.entity.User");
		List<User> userList = query.getResultList();
		return userList;
	}
			
	public void addUser(User user){
		Query query = em.createQuery("FROM com.entity.User");
		List<User> users = query.getResultList();
		if(!users.contains(user))
			em.persist(user);
	}
	
	public void deleteUser(User user){
		Query query = em.createQuery("FROM com.entity.User");
		List<User> users = query.getResultList();
		if(users.contains(user))
			em.remove(user);
	}

	public User getUserByUsernameAndPassword(String username,String password) {
		Query query = em.createQuery("FROM com.entity.User");
		List<User> users = query.getResultList();
		for (User user:users){
			if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
				return user;
			}
			else{
				User nullUser = new User(null,null,null,null);
				return nullUser;
			}
		}
		return null;
	}

	public User getUserByName(String name) {
		Query query = em.createQuery("FROM com.entity.User");
		List<User> users = query.getResultList();
		for (User user: users){
			if(user.getName().equals(name)){
				return user;
			}		
		}
		return null;
	}

}
