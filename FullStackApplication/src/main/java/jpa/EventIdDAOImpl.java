package jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.EventIdDAO;
import entities.EventId;

@Stateless
@Local
public class EventIdDAOImpl implements EventIdDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<EventId> getEventId() {
		Query q = em.createQuery("select eId from EventId eId left join fetch eId.eventCauses");
		return q.getResultList();
	}
	
	public void createEventId(Integer event){
		EventId eventId = new EventId(event);
		em.persist(eventId);
	}
	public EventId getByEventId(Integer eventId){
		Query q = em.createQuery("select eid from EventId eid where eid.eventId = "+eventId+" left join fetch eid.eventCauses", EventId.class);
		List<EventId> causes = q.getResultList();
		return causes.get(0);
	}
}