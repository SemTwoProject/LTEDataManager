package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.UEDAO;
import com.entity.Fault;
import com.entity.UE;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class UEDAOImpl implements UEDAO {

	@PersistenceContext
	private EntityManager em;

	public Collection<UE> getUE() {
		Query q = em.createQuery("select u from UE u");
		return q.getResultList();
	}

	public UE getByTac(Integer tac) {
		Query q = em.createQuery("select u from UE u where u.tac = :tac",
				UE.class);
		q.setParameter("tac", tac);
		List<UE> tacs = q.getResultList();
		return tacs.get(0);
	}

	public Collection<Fault> getEventCausePerModel(String model) {
		Query q = em.createQuery("select distinct eventCause.eventId,eventCause.causeCode,eventCause.description, Count(*) "
				+ "FROM Fault f where f.tac.model = :model group by eventCause.eventId, eventCause.causeCode");
	
		q.setParameter("model", model);
			
		List<Fault> modelFailure = q.getResultList();
		return modelFailure;
	}

}