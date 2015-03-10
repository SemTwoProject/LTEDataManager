package com.jpa;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.FaultDAO;
import com.entity.EventCause;
import com.entity.Fault;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class FaultDAOImpl implements FaultDAO
{
	
	@PersistenceContext
	private EntityManager em;
	
	public Collection<Fault> getFault()
	{
		Query q = em.createQuery("select f from Fault f");
		return q.getResultList();
	}
	
	public Fault getById(Integer id)
	{
		Query q = em.createQuery("select f from Fault f where f.id = :id",
				Fault.class);
		q.setParameter("id", id);
		List<Fault> faults = q.getResultList();
		return faults.get(0);
	}
	
	public Collection<EventCause> getFaultByIMSI(Long imsi)
	{
		Collection<Fault> faults = getFaultsByIMSI(imsi);
		List<EventCause> results = new ArrayList<EventCause>();
		for (Fault fault : faults)
		{
			results.add(getCauseCodeByFault(fault));
		}
		return results;
	}
	
	public Collection<Fault> getFaultsByIMSI(Long imsi)
	{
		Query q = em.createQuery("select f from Fault f where f.imsi = :imsi",
				Fault.class).setParameter("imsi", imsi);
		List<Fault> faults = q.getResultList();
		return faults;
	}
	
	public EventCause getCauseCodeByFault(Fault fault)
	{
		Query q = em
				.createQuery(
						"select e from EventCause e where e.eventId = :eventId and e.causeCode = :eventCause",
						EventCause.class);
		q.setParameter("eventId", fault.getEventCause().getEventId());
		q.setParameter("eventCause", fault.getEventCause().getCauseCode());
		List<EventCause> fails = q.getResultList();
		return fails.get(0);
	}
	
	public Collection<Fault> getTotalFaultsAndDurationPerIMSI(Timestamp start,
			Timestamp end)
	{						
		Query q = em
				.createQuery(
						"select IMSI as IMSI, COUNT(f.imsi) as TotalFailures, SUM(duration) as TotalDuration "
						+ "from Faults f where f.date >= :startdate and f.date <= :enddate group by IMSI",
						Fault.class);
		q.setParameter("startdate", start);
		q.setParameter("enddate", end);
		Collection<Fault> result = q.getResultList();
		return result;
	}
}