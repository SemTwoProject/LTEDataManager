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
import com.entity.Failure;
import com.entity.Fault;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class FaultDAOImpl implements FaultDAO {

	@PersistenceContext
	private EntityManager em;

	public Collection<Fault> getFault() {
		Query q = em.createQuery("select f from Fault f");
		return q.getResultList();
	}

	public Fault getById(Integer id) {
		Query q = em.createQuery("select f from Fault f where f.id = :id",
				Fault.class);
		q.setParameter("id", id);
		List<Fault> faults = q.getResultList();
		return faults.get(0);
	}

	/*
	 * public Collection<Object> getFaultByIMSIOd(Long imsi) { Collection<Fault>
	 * faults = getFaultsByImsi(imsi); List<Object> results = new
	 * ArrayList<Object>(); for (Fault fault : faults) {
	 * //results.add(getEventIdByFault(fault));
	 * results.add(getFailureByFault(fault)); } return results; }
	 */

	public Collection<Fault> getFaultByIMSI(Long imsi) {
		Query q = em
				.createQuery(
						"select distinct f.tac, f.eventCause from Fault f where f.imsi = :imsi").setParameter("imsi", imsi);
		List<Fault> faults = q.getResultList();
		return faults;
	}

	public Object getFailureByFault(Fault fault) {
		Query q = em
				.createQuery(
						"select distinct f from Failure f left join fetch f.faultList where f.failure = :fault",
						Failure.class);
		q.setParameter("fault", fault.getFailure().getfailure());
		List<Object> fails = q.getResultList();
		return fails.get(0);
	}

	/**
	 * Helper queries for constructing a Fault by retrieving the relevant entity
	 * objects
	 */

	public Collection<Object> getTotalFaultsAndDurationPerIMSI(Timestamp start,
			Timestamp end) {
		// Query q =
		// em.createQuery("select IMSI as IMSI, COUNT(f.id) as TotalFailures, SUM(duration) as TotalDuration from Faults f Group By IMSI");
		return null;
	}

}