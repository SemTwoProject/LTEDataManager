package com.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entity.User;



public class PersistenceUtil implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("LTEDataManager"); 	
	
	
	public static void persist(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
	}

	public static void remove(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Object mergedEntity = em.merge(entity);
		em.remove(mergedEntity);
		em.getTransaction().commit();
		em.close();
	}
	
	public static Object merge(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		entity = em.merge(entity);
		em.getTransaction().commit();		
		em.close();
		return entity;
	}

	public static EntityManager createEM() {
		return emf.createEntityManager();
	}
	
	
	public static List<User> findAllUsers(){
		EntityManager em = emf.createEntityManager();
		List<User> Users = (List<User>) 
				em.createNamedQuery("User.findAll").getResultList();
		em.close();
		
		return Users;
		
	}
	

	public static User findUserByUsername(String username){
		
		EntityManager em = emf.createEntityManager();
		List<User> users = (List<User>) 
				em.createNamedQuery("User.findByUsername").
				setParameter("username", username).getResultList();
		em.close();
		
		if (users.size() == 0)
			return null;
		else 
			return users.get(0);
	}
	

	
}

