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
<<<<<<< HEAD
=======
import com.entity.Fault;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68

@Stateless
@Local
@SuppressWarnings("unchecked")
public class FailureDAOImpl implements FailureDAO {

	@PersistenceContext
	private EntityManager em;

	public Collection<Failure> getFailure() {
<<<<<<< HEAD
		Query q = em.createQuery("select fl from Failure fl left join fetch fl.faultList");
		return q.getResultList();

	}
	public Failure getByFailure(Integer failure){
		Query q = em.createQuery("select f from Failure f where f.failure = "+failure+" left join fetch f.faultList", Failure.class);
=======
		Query q = em
				.createQuery("select f from Failure f");
		return q.getResultList();
	}

	public Failure getByFailure(Integer failure) {
		Query q = em.createQuery("select f from Failure f where f.failure = :failure",
				Failure.class);
		q.setParameter("failure", failure);
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
		List<Failure> fails = q.getResultList();
		return fails.get(0);
	}
	
<<<<<<< HEAD
	public void createFailure(Integer failure, String description){
		Failure fail = new Failure(failure, description);
		em.persist(fail);
=======
	public Collection<Object> getFailureByFault(Fault fault) {
		Query q = em.createQuery("select f from Failure f where f.fault = :fault",
				Failure.class);
		q.setParameter("fault", fault.getFailure());
		List<Object> fails = q.getResultList();
		return fails;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
	}
}