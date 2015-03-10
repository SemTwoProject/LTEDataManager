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
import javax.persistence.TemporalType;

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
	
	public Collection<Fault> getFaultsByIMSI(Long imsi)
	{
		Query q = em.createQuery("select f from Fault f where f.imsi = :imsi",
				Fault.class).setParameter("imsi", imsi);
		List<Fault> faults = q.getResultList();
		return faults;
	}
	
	public Collection<Fault> getEventCausePerIMSI(Long imsi)
	{
		Query q = em.createQuery("select eventCause.eventId, eventCause.causeCode From Fault f where f.imsi = :imsi Group by eventCode");
		q.setParameter("imsi",imsi);
		
		return q.getResultList();
	}
	
	public Collection<Fault> getTotalFaultsAndDurationPerIMSI(Timestamp start,Timestamp end)
	{						
		Query q = em.createQuery("select imsi, COUNT(f.imsi), SUM(duration) "
				+ "from Fault f where f.date >= :startdate and f.date <= :enddate group by f.imsi");
		q.setParameter("startdate", start);
		q.setParameter("enddate", end);
		Collection<Fault> result = q.getResultList();
		return result;
	}
	
	public Long getIMSICount(Timestamp start, Timestamp end,
			Long imsi) {
		
		Query q = em.createQuery("select COUNT(*) FROM Fault i WHERE i.imsi = :imsi AND i.date >= :start AND i.date <= :end");
		q.setParameter("start", start);
		q.setParameter("end", end);
		q.setParameter("imsi", imsi);
		
		List<Long> failureCount = q.getResultList();
		return failureCount.get(0);
	}

	public Collection<Fault> getCauseCodePerIMSI(Long imsi) {
		Query q = em.createQuery("select distinct eventCause.causeCode FROM Fault i WHERE i.imsi = :imsi");
		q.setParameter("imsi", imsi);
		
		return q.getResultList();
	}

	public Collection<Fault> getIMSIFailureOverTime(Timestamp start,Timestamp end) {
		Query q = em.createQuery("select distinct imsi from Fault i where i.date >= :start AND i.date <= :end");
		q.setParameter("start", start);
		q.setParameter("end", end);
		
		return q.getResultList();
	}

	//Select imsi from faults where failure = 3
	
	@Override
	public Collection<Fault> getImsiPerFailure(int failure) {
		Query q = em.createQuery("select imsi FROM Fault f where f.failure.failure = :failure");
	
		q.setParameter("failure", failure);
			
		List<Fault> imsiFailure = q.getResultList();
		return imsiFailure;
	}

	@Override
	public Long getNumberOfCallFailuresPerModel(String model,
			Timestamp from, Timestamp to) {
		Query q = em.createQuery(
				"select count(f) from Fault f where tac.model=:model AND f.date BETWEEN :from AND :to")
				.setParameter("model", model)
				.setParameter("from", from,TemporalType.TIMESTAMP)
				.setParameter("to", to,TemporalType.TIMESTAMP);
		return (Long)q.getResultList().get(0);
	}
}
