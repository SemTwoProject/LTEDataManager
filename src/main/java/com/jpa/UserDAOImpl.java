package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.UserDAO;
import com.entity.User;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class UserDAOImpl implements UserDAO {
	
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

	public Collection<User> getUserByUsernameAndPassword(String username,String password) {
		Query query = em.createQuery("Select u From User u where u.username = :username AND u.password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		List<User> users = query.getResultList();
		return users;
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
