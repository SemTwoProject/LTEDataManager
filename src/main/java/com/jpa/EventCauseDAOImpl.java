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
import com.entity.EventId;
<<<<<<< HEAD
=======
import com.entity.Fault;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68

@Stateless
@Local
@SuppressWarnings("unchecked")
public class EventCauseDAOImpl implements EventCauseDAO {

	@PersistenceContext
	private EntityManager em;

<<<<<<< HEAD

=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
	public Collection<EventCause> getEventCause() {
		Query q = em.createQuery("select ec from EventCause ec");
		return q.getResultList();
	}
<<<<<<< HEAD
	public EventCause getByEventCause(Integer event){
		Query q = em.createQuery("select e from EventCause e where e.event = "+event, EventCause.class);
		List<EventCause> causes = q.getResultList();
		return causes.get(0);
	}
	
	public void createEventCause(Integer event, String description, EventId eventId){
		EventCause eventCause = new EventCause(event, description, eventId);
		em.persist(eventCause);
=======

	public EventCause getByEventCause(Integer event) {
		Query q = em.createQuery(
				"select e from EventCause e where e.cause = :event",
				EventCause.class);
		q.setParameter("event", event);
		List<EventCause> causes = q.getResultList();
		return causes.get(0);
	}

	public List<Object> getEventCauseByFault(Fault fault) {
		Query q = em.createQuery(
				"select e from EventCause e where e.eventId = :fault",
				EventCause.class);
		q.setParameter("fault", fault.getEventId());
		List<Object> causes = q.getResultList();
		return causes;
	}

	public EventId getByEventId(Integer eventId) {
		Query q = em.createQuery(
				"select e from EventId e where e.eventId = :eventId",
				EventId.class);
		q.setParameter("eventId", eventId);
		List<EventId> events = q.getResultList();
		return events.get(0);
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
	}
}