package com.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.FaultDAO;
import com.entity.CellHier;
import com.entity.Failure;
import com.entity.Fault;
import com.entity.UE;

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

	public Collection<Object> getFaultByIMSI(Long imsi) {
		Collection<Fault> faults = getFaultsFromImsi(imsi);
		List<Object> results = new ArrayList<Object>();
		for (Fault fault : faults) {
			//results.add(getEventIdByFault(fault));
			results.add(getFailureByFault(fault));
		}
		return results;
	}

	@Override
	public Fault getByEventId(Integer eventId) {
		return null;
	}
	public Collection<Fault> getFaultsFromImsi(Long imsi) {
		Query q = em.createQuery(
				"select f from Fault f where f.imsi.imsi = :imsi", Fault.class)
				.setParameter("imsi", imsi);
		List<Fault> faults = q.getResultList();
		return faults;
	}

	public Object getFailureByFault(Fault fault) {
		Query q = em.createQuery("select distinct f from Failure f left join fetch f.faultList where f.failure = :fault",
				Failure.class);
		q.setParameter("fault", fault.getFailure().getfailure());
		List<Object> fails = q.getResultList();
		return fails.get(0);
	}

	/**
	 * Helper queries for constructing a Fault by retrieving the relevant entity
	 * objects
	 */

	public Failure getByFailure(Integer failure) {
		Query q = em.createQuery(
				"select f from Failure f where f.failure.failure = :failure",
				Failure.class);
		q.setParameter("failure", failure);
		List<Failure> fails = q.getResultList();
		return fails.get(0);
	}

	public CellHier getByCellId(Integer cellId) {
		Query q = em.createQuery(
				"select c from CellHier c where c.cellId.cellId = :cellId",
				CellHier.class);
		q.setParameter("cellId", cellId);
		List<CellHier> cells = q.getResultList();
		return cells.get(0);
	}

	public UE getByTac(Integer tac) {
		Query q = em.createQuery("select u from UE u where u.tac.tac = :tac",
				UE.class);
		q.setParameter("tac", tac);
		List<UE> tacs = q.getResultList();
		System.out.println("ResultSet: "+ tacs.size());
		return tacs.get(0);
	}
	//Unfinished
//	@Override
//	public Collection<Object> getTotalFaultsAndDurationPerIMSI()
//	{
//		Query q = em.createQuery("select IMSI as IMSI, COUNT(f.id) as TotalFailures, SUM(duration) as TotalDuration from Faults f Group By IMSI");
//		return null;
//	}	

	@Override
	public Collection<Object> getTotalFaultsAndDurationPerIMSI() {
		// TODO Auto-generated method stub
		return null;
	}

	
}