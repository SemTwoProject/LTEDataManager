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
	
	public Collection<Fault> getEventCausePerIMSI(Long imsi)
	{
		Query q = em
				.createQuery("select eventCause.eventId, eventCause.causeCode From Fault f where f.imsi = :imsi Group by eventCode");
		q.setParameter("imsi", imsi);
		return q.getResultList();
	}
	
	// Story 4 - As Customer Service Rep. I want to display, for a given
	// affected IMSI, the Event ID and Cause Code for any / all failures
	// affecting that IMSI
	public Collection<Fault> getFaultsByIMSI(Long imsi)
	{
		Query q = em
				.createQuery("select distinct imsi, cause, event_id from Faults f where f.imsi = :imsi");
		q.setParameter("imsi", imsi);
		Collection<Fault> result = q.getResultList();
		return result;
	}
	
	// Story 5 - As a Support Engineer I want to see a list of all IMSIs with
	// call failures during a given time period
	public Collection<Fault> getIMSIFailureOverTime(Timestamp start,
			Timestamp end)
	{
		Query q = em
				.createQuery("select distinct imsi, event_id, date_time from Faults i where i.date >= :start AND i.date <= :end");
		q.setParameter("start", start);
		q.setParameter("end", end);
		Collection<Fault> result = q.getResultList();
		return result;
	}
	
	// Story 12 - As a Customer Service Rep, I want to count, for a given IMSI,
	// the number of failures they have had during a given time period.
	public Collection<Fault> getIMSICount(Timestamp start, Timestamp end,
			Long imsi)
	{
		Query q = em
				.createQuery("select imsi, COUNT(*) FROM Faults i WHERE i.imsi = :imsi AND i.date >= :start AND i.date <= :end");
		q.setParameter("start", start);
		q.setParameter("end", end);
		q.setParameter("imsi", imsi);
		Collection<Fault> result = q.getResultList();
		return result;
	}
	
	// Story 17 - As a Customer Service Rep. I want to see, for a given IMSI,
	// all the unique Cause Codes associated with its call failures
	public Collection<Fault> getCauseCodePerIMSI(Long imsi)
	{
		Query q = em
				.createQuery("select distinct imsi, cause FROM Faults i WHERE i.imsi = :imsi");
		q.setParameter("imsi", imsi);
		Collection<Fault> result = q.getResultList();
		return result;
	}
	
	// Story 18 - As a Network Management Engineer I want to see the Top 10
	// IMSIs that had call failures during a time period
	public Collection<Fault> getTopTenIMSIOverTime(Timestamp start,
			Timestamp end)
	{
		Query q = em
				.createQuery("select imsi, count(f.imsi) from faults f where f.date >= :startdate and f.date <= :enddate group by f.imsi order by count(f.imsi) desc limit 10");
		q.setParameter("startdate", start);
		q.setParameter("enddate", end);
		Collection<Fault> result = q.getResultList();
		return result;
	}
	
	// Story 7 - As a Network Management Engineer I want to count, for each
	// IMSI, the number of call failures and their total duration during a given
	// time period
	public Collection<Fault> getTotalFaultsAndDurationPerIMSI(Timestamp start,
			Timestamp end)
	{
		Query q = em
				.createQuery("select imsi, COUNT(f.imsi), SUM(duration) "
						+ "from Faults f where f.date >= :startdate and f.date <= :enddate group by f.imsi");
		q.setParameter("startdate", start);
		q.setParameter("enddate", end);
		Collection<Fault> result = q.getResultList();
		return result;
	}
	
	// Select imsi from faults where failure = 3
	@Override
	public Collection<Fault> getImsiPerFailure(int failure)
	{
		Query q = em
				.createQuery("select imsi FROM Faults f where f.failure.failure = :failure");
		q.setParameter("failure", failure);
		List<Fault> imsiFailure = q.getResultList();
		return imsiFailure;
	}
}
