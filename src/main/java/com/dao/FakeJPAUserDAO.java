package com.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import com.entity.User;

public class FakeJPAUserDAO {
	
	private Set<User> database;
	
	public FakeJPAUserDAO(){
		database = new HashSet<User>();
		database.add(new User("Test User 1","user1","password","System Administrator"));
		database.add(new User("Test User 2","user2","password","Network Administrator"));
		database.add(new User("Test User 3","user3","password","System Administrator"));
		database.add(new User("Test User 4","user4","password","System Administrator"));
		database.add(new User("Test User 5","user5","password","System Administrator"));
	}
	
	public Collection<User> getAllUsers() {
		return database;
	}
	
	public void addUser(User user){
		if(!database.contains(user)){
			database.add(user);
		}
	}
	
	public void deleteUser(User user){
		if(database.contains(user)){
			database.remove(user);
		}
	}
	
	public User getUserByUsernameAndPassword(String username, String password){
		for (User users:database){
			if(users.getUsername().equals(username)&&users.getPassword().equals(password)){
				return users;
			}
		}
		return null;
	}
	
	public User getUserByName(String name) {
		for (User users:database){
			if(users.getName().equals(name)){
				return users;
			}		
		}
		return null;
	}
}
