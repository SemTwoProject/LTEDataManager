package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.EventCauseDAO;
import com.entity.EventCause;
import com.entity.Fault;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class EventCauseDAOImpl implements EventCauseDAO {

	@PersistenceContext
	private EntityManager em;

	public Collection<EventCause> getEventCause(Integer causeid) {
		Query q = em.createQuery(
				"select e from EventCause e where e.cause = :causeid",
				EventCause.class);
		q.setParameter("causeid", causeid);
		List<EventCause> causes = q.getResultList();
		return causes;
	}

	public Collection<EventCause> getByEventCause(Integer event) {
		Query q = em.createQuery(
				"select e from EventCause e where e.event_id = :event",
				EventCause.class);
		q.setParameter("event", event);
		List<EventCause> causes = q.getResultList();
		return causes;
	}

	public Collection<EventCause> getEventCauseByFault(Fault fault) {
		Query q = em.createQuery(
				"select e from EventCause e where e.eventId = :fault",
				EventCause.class);
		q.setParameter("fault", fault.getEventCause().getEventId());
		List<EventCause> causes = q.getResultList();
		return causes;
	}
}