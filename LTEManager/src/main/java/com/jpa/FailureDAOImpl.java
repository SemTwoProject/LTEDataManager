package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.FailureDAO;
import com.entities.Failure;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class FailureDAOImpl implements FailureDAO {

	@PersistenceContext
	private EntityManager em;

	public Collection<Failure> getFailure() {
		Query q = em.createQuery("select fl from Failure fl left join fetch fl.faultList");
		return q.getResultList();

	}
	public Failure getByFailure(Integer failure){
		Query q = em.createQuery("select f from Failure f where f.failure = "+failure+" left join fetch f.faultList", Failure.class);
		List<Failure> fails = q.getResultList();
		return fails.get(0);
	}
	
	public void createFailure(Integer failure, String description){
		Failure fail = new Failure(failure, description);
		em.persist(fail);
	}
}