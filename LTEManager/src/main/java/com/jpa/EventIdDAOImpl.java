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
	
	public void createEventIds(){
		EventId id = new EventId();
		id = new EventId(4097);
		em.persist(id);
		id = new EventId(4098);
		em.persist(id);
		id = new EventId(4125);
		em.persist(id);
		id = new EventId(4106);
		em.persist(id);
	}

	public Collection<EventId> getEventId() {
		Query q = em.createQuery("select eId from EventId eId");
		return q.getResultList();
	}
	public EventId getByEventId(Integer eventId){
		Query q = em.createQuery("select eid from EventId eid where eid.eventId = '"+eventId+"'", EventId.class);
		List<EventId> causes = q.getResultList();
		return causes.get(0);
	}
	
}