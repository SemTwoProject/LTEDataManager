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
	
	public void createFailures(){
		Failure fail;
		fail = new Failure(0,"EMERGENCY");
		em.persist(fail);
		fail = new Failure(1,"HIGH PRIORITY ACCESS");
		em.persist(fail);
		fail = new Failure(2,"MT ACCESS");
		em.persist(fail);
		fail = new Failure(3,"MO SIGNALLING");
		em.persist(fail);
		fail = new Failure(4,"MO DATA");
		em.persist(fail);
	}

	public Collection<Failure> getFailure() {
		Query q = em
				.createQuery("select fl from Failure fl left join fetch fl.faultList");
		return q.getResultList();
	}

	public Failure getByFailure(Integer failure) {
		Query q = em.createQuery("select f from Failure f where f.failure = '"
				+ failure +"'", Failure.class);
		List<Failure> fails = q.getResultList();
		return fails.get(0);
	}
	
	public Collection<Object> getFailureByFault(Fault fault){
		Query q = em.createQuery("select f from Failure f where f.failure = '"+fault.getFailure()+"'", Failure.class);
		List<Object> fails = q.getResultList();
		return fails;
	}
}