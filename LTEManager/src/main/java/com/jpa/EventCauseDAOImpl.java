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

	public Collection<EventCause> getEventCause() {
		Query q = em.createQuery("select ec from EventCause ec");
		return q.getResultList();
	}
	public EventCause getByEventCause(Integer event){
		Query q = em.createQuery("select e from EventCause e where e.event = "+event, EventCause.class);
		List<EventCause> causes = q.getResultList();
		return causes.get(0);
	}
	
	public List<Object> getEventCauseByFault(Fault fault){
		Query q = em.createQuery("select e from EventCause e where e.eventId = "+fault.getEventId()+" group by e.eventId");
		return q.getResultList();
	}
}