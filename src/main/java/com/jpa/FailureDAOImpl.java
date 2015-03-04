<<<<<<< HEAD
package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.FailureDAO;
import com.entity.Failure;
import com.entity.Fault;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class FailureDAOImpl implements FailureDAO {

	@PersistenceContext
	private EntityManager em;

	public Collection<Failure> getFailure() {
		Query q = em
				.createQuery("select f from Failure f");
		return q.getResultList();
	}

	public Failure getByFailure(Integer failure) {
		Query q = em.createQuery("select f from Failure f where f.failure = :failure",
				Failure.class);
		q.setParameter("failure", failure);
		List<Failure> fails = q.getResultList();
		return fails.get(0);
	}
	
	public Collection<Object> getFailureByFault(Fault fault) {
		Query q = em.createQuery("select f from Failure f where f.fault = :fault",
				Failure.class);
		q.setParameter("fault", fault.getFailure());
		List<Object> fails = q.getResultList();
		return fails;
	}
=======
package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.FailureDAO;
import com.entity.Failure;
import com.entity.Fault;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class FailureDAOImpl implements FailureDAO {

	@PersistenceContext
	private EntityManager em;

	public Collection<Failure> getFailure() {
		Query q = em
				.createQuery("select f from Failure f");
		return q.getResultList();
	}

	public Failure getByFailure(Integer failure) {
		Query q = em.createQuery("select f from Failure f where f.failure.failure = :failure",
				Failure.class);
		q.setParameter("failure", failure);
		List<Failure> fails = q.getResultList();
		return fails.get(0);
	}
	
	public Collection<Object> getFailureByFault(Fault fault) {
		Query q = em.createQuery("select f from Failure f where f.fault = :fault",
				Failure.class);
		q.setParameter("fault", fault.getFailure());
		List<Object> fails = q.getResultList();
		return fails;
	}
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
}