package jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.FaultDAO;
import entities.CellHier;
import entities.Duration;
import entities.EventCause;
import entities.EventId;
import entities.Failure;
import entities.Fault;
import entities.MCC;
import entities.MNC;
import entities.NEVersion;
import entities.UE;

@Stateless
@Local
public class FaultDAOImpl implements FaultDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<Fault> getFault() {
		Query q = em.createQuery("select ft from Fault ft");
		return q.getResultList();
	}

	public Fault getById(Integer id) {
		Query q = em.createQuery("select f from Fault f where f.id = " + id,
				Fault.class);
		List<Fault> faults = q.getResultList();
		return faults.get(0);
	}

	public void createFault(String date, EventId eventId, Failure failure, UE tac, MCC mcc,
			MNC mnc, CellHier cellId, 
			Duration duration, EventCause eventCause, NEVersion ne){
		Fault fault = new Fault(date, eventId, failure, tac, mcc, mnc, cellId,
				duration, eventCause, ne);
		em.persist(fault);
	}
}