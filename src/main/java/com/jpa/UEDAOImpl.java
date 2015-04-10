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

@Stateless
@Local
@SuppressWarnings("unchecked")
public class UEDAOImpl implements UEDAO {

	@PersistenceContext
	private EntityManager em;

	public Collection<Fault> getEventCausePerModel(String model) {
		Query q = em.createQuery("select distinct eventCause.eventId,eventCause.causeCode,eventCause.description, Count(*) "
				+ "FROM Fault f where f.tac.model = :model group by eventCause.eventId, eventCause.causeCode");
		q.setParameter("model", model);
		List<Fault> modelFailure = q.getResultList();
		return modelFailure;
	}

}