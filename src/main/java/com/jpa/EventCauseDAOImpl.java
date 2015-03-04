<<<<<<< HEAD
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

	public EventCause getEventCause(Integer causeid) {
		Query q = em.createQuery(
				"select e from EventCause e where e.causeid = :causeid",
				EventCause.class);
		q.setParameter("causeid", causeid);
		List<EventCause> causes = q.getResultList();
		return causes.get(0);
	}

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
=======
package com.jpa;

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

	public EventCause getEventCause(Integer causeid) {
		Query q = em.createQuery(
				"select e from EventCause e where e.causeid = :causeid",
				EventCause.class);
		q.setParameter("causeid", causeid);
		List<EventCause> causes = q.getResultList();
		return causes.get(0);
	}

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
		q.setParameter("fault", fault.getEventCause());
		List<Object> causes = q.getResultList();
		return causes;
	}
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
}