package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.EventIdDAO;
import com.entity.EventId;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class EventIdDAOImpl implements EventIdDAO {

	@PersistenceContext
	private EntityManager em;

	public Collection<EventId> getEventId() {
		Query q = em.createQuery("select eId from EventId eId");
		return q.getResultList();
	}

	public EventId getByEventId(Integer eventId) {
		Query q = em.createQuery("select e from EventId e where e.eventId = :eventId",
				EventId.class);
		 q.setParameter("eventId", eventId);
		 List<EventId> events = q.getResultList();
		return events.get(0);
	}
}