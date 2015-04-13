package com.jpa;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.FaultDAO;
import com.entity.Fault;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class FaultDAOImpl implements FaultDAO {  

	@PersistenceContext
	private EntityManager em;

	// Story 4 - As Customer Service Rep. I want to display, for a given
	// affected IMSI, the Event ID and Cause Code for any / all failures
	// affecting that IMSI
	public Collection<Fault> getEventCausePerIMSI(Long imsi) {
		Query q = em
				.createQuery("select eventCause.eventId, eventCause.causeCode, eventCause.description,failure.description,date From Fault f where f.imsi = :imsi");
		q.setParameter("imsi", imsi);
		return q.getResultList();
	}
	
	// Story 15 - As a Network Management Engineer I want to see the 
	//Top 10 Market/Operator/Cell ID combinations that 
	//had call failures during a time period 
	public Collection<Fault> getTopTenMarketOperatorCell(Timestamp start, Timestamp end) {
		Query q = em
				.createQuery("select distinct mccid.country, mccid.operator, cell.cellId, count(*) from Fault f WHERE f.date >= :start AND f.date <= :end group by f.mccid.mccId,f.mccid.mncId,f.cell.cellId order by count(*) desc");
		q.setParameter("start", start);
		q.setParameter("end", end);
		Collection<Fault> result = q.getResultList();
		System.out.println(result);
		return result;
	}

	
	public List<Fault> getFaultsByIMSI(Long imsi) {
		Query q = em
				.createQuery("select distinct imsi, eventCause.causeCode, eventCause.eventId from Fault f where f.imsi = :imsi");
		q.setParameter("imsi", imsi);
		List<Fault> result = q.getResultList();
		return result;
	}

	// Story 5 - As a Support Engineer I want to see a list of all IMSIs with
	// call failures during a given time period
	public Collection<Fault> getIMSIFailureOverTime(Timestamp start,
			Timestamp end) {
		Query q = em
				.createQuery("select distinct imsi, eventCause.description,failure.description,mccid.operator,mccid.country,duration, date from Fault i where i.date >= :start AND i.date <= :end");
		q.setParameter("start", start);
		q.setParameter("end", end);
		Collection<Fault> result = q.getResultList();
		return result;
	}

	// Story 12 - As a Customer Service Rep, I want to count, for a given IMSI,
	// the number of failures they have had during a given time period.
	public Collection<Fault> getIMSICount(Timestamp start, Timestamp end,
			Long imsi) {
		Query q = em
				.createQuery("select COUNT(*) FROM Fault i WHERE i.imsi = :imsi AND i.date >= :start AND i.date <= :end");
		q.setParameter("start", start);
		q.setParameter("end", end);
		q.setParameter("imsi", imsi);
		Collection<Fault> result = q.getResultList();
		return result;
	}

	// Story 17 - As a Customer Service Rep. I want to see, for a given IMSI,
	// all the unique Cause Codes associated with its call failures
	public Collection<Fault> getCauseCodePerIMSI(Long imsi) { 
		Query q = em
				.createQuery("select Distinct eventCause.causeCode, COUNT(eventCause.causeCode) FROM Fault i WHERE i.imsi = :imsi Group by eventCause.causeCode");
		q.setParameter("imsi", imsi);
		Collection<Fault> result = q.getResultList();
		return result;
	}

	// Story 18 - As a Network Management Engineer I want to see the Top 10
	// IMSIs that had call failures during a time period
	public Collection<Fault> getTopTenIMSIOverTime(Timestamp start,
			Timestamp end) {
		Query q = em
				.createQuery("select imsi, count(f.imsi) from Fault f where f.date >= :startdate and f.date <= :enddate group by f.imsi order by count(f.imsi) desc");
		q.setMaxResults(10);
		q.setParameter("startdate", start);
		q.setParameter("enddate", end);
		Collection<Fault> result = q.getResultList();
		return result;
	}

	// Story 7 - As a Network Management Engineer I want to count, for each
	// IMSI, the number of call failures and their total duration during a given
	// time period
	public Collection<Fault> getTotalFaultsAndDurationPerIMSI(Timestamp start,
			Timestamp end) {
		Query q = em
				.createQuery("select imsi, COUNT(f.imsi), SUM(duration) "
						+ "from Fault f where f.date >= :startdate and f.date <= :enddate group by f.imsi");
		q.setParameter("startdate", start);
		q.setParameter("enddate", end);
		Collection<Fault> result = q.getResultList();
		return result;
	}

	// Story 6 - As a Support Engineer I want to count, for a given model of
	// phone, the number of call failures it has had during a given time period.
	public Collection<Fault> getNumberOfCallFailuresPerModel(String model,
			Timestamp from, Timestamp to) {
		Query q = em
				.createQuery("select tac.manufacturer, count(f) from Fault f where tac.model=:model AND f.date BETWEEN :from AND :to group by tac.model");
		q.setParameter("model", model);
		q.setParameter("from", from);
		q.setParameter("to", to);
		Collection<Fault> result = q.getResultList();
		return result;
	}

	//Story 19 - As a Support Engineer I want to display, for a given failure cause class, the IMSIs that were affected
	@Override
	public Collection<Fault> getImsiPerFailure(int failure) {
		Query q = em
				.createQuery("select imsi,eventCause.description,mccid.operator,mccid.country,date FROM Fault f where f.failure.failure = :failure Order by imsi");
		q.setParameter("failure", failure);
		System.out.println("Failure: " + failure);
		List<Fault> imsiFailure = q.getResultList();
		return imsiFailure;
	}
	
	public Collection<Fault> getEventCausePerModel(String model) {
		Query q = em.createQuery("select distinct eventCause.eventId,eventCause.causeCode,eventCause.description, Count(*) "
				+ "FROM Fault f where f.tac.model = :model group by eventCause.eventId, eventCause.causeCode");
		q.setParameter("model", model);
		List<Fault> modelFailure = q.getResultList();
		return modelFailure;
	}
	
	public Collection<Fault> getFaultsForCell(int marketid, int operatorid, int cellid) {
		Query q = em.createQuery("select distinct imsi, eventCause.causeCode, eventCause.eventId, eventCause.description, failure.description, date from Fault f where mccid.mccId = :mccid AND mccid.mncId = :mncid AND cell.cellId = :cellid");
		q.setParameter("mccid", marketid);
		q.setParameter("mncid", operatorid);
		q.setParameter("cellid", cellid);
		List<Fault> faultsForCell = q.getResultList();
		return faultsForCell;
	}
	
	public Collection<Fault> getFaultsForModelCombo(String model, int eventid, int causecode) {
		Query q = em.createQuery("select distinct imsi, eventCause.causeCode, eventCause.eventId, eventCause.description, failure.description, date from Fault f where tac.model = :model AND eventCause.eventId = :eventid AND eventCause.causeCode = :causecode");
		q.setParameter("model", model);
		q.setParameter("eventid", eventid);
		q.setParameter("causecode", causecode);
		List<Fault> faults = q.getResultList();
		return faults;
	}

	
	public Collection<String> getAllModels() {
		Query q = em.createQuery("Select u.model from UE u");
		List<String> models = q.getResultList();
		return models;
	}

	@Override
	public Collection<String> getFailureDescriptions() {
		Query q = em.createQuery("Select f.description from Failure f");
		List<String> desc = q.getResultList();
		return desc;
	}

	@Override
	public Collection<Long> getIMSIS() {
		Query q = em.createQuery("Select distinct f.imsi from Fault f");
		Collection<Long> imsis = q.getResultList();
		return imsis;
	}
}
