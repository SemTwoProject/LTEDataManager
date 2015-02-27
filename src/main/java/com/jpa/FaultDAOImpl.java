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
import com.entity.Duration;
import com.entity.EventCause;
import com.entity.EventId;
import com.entity.Failure;
import com.entity.Fault;
import com.entity.IMSI;
import com.entity.MCC;
import com.entity.MNC;
import com.entity.NEVersion;
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
			results.addAll(getEventIdByFault(fault));
			results.addAll(getFailureByFault(fault));
		}
		return results;
	}

	public Collection<Fault> getFaultsFromImsi(Long imsi) {
		Query q = em.createQuery(
				"select f from Fault f where f.imsi.imsi = :imsi", Fault.class)
				.setParameter("imsi", imsi);
		List<Fault> faults = q.getResultList();
		return faults;
	}

	public List<Object> getEventIdByFault(Fault fault) {
		Query q = em
				.createQuery(
						"select distinct e from EventId e left join fetch e.eventCauses where e.eventId = :fault",
						EventCause.class);
		q.setParameter("fault", fault.getEventId().getEventId());
		List<Object> causes = q.getResultList();
		return causes;
	}

	public Collection<Object> getFailureByFault(Fault fault) {
		Query q = em.createQuery(
				"select distinct f from Failure f left join fetch"
						+ " f.faultList where f.failure = :fault",
				Failure.class);
		q.setParameter("fault", fault.getFailure().getfailure());
		List<Object> fails = q.getResultList();
		return fails;
	}

	/**
	 * Helper queries for constructing a Fault by retrieving the relevant entity
	 * objects
	 */

	public Failure getByFailure(Integer failure) {
		Query q = em.createQuery(
				"select f from Failure f where f.failure = :failure",
				Failure.class);
		q.setParameter("failure", failure);
		List<Failure> fails = q.getResultList();
		return fails.get(0);
	}

	public CellHier getByCellId(Integer cellId) {
		Query q = em.createQuery(
				"select c from CellHier c where c.cellId = :cellId",
				CellHier.class);
		q.setParameter("cellId", cellId);
		List<CellHier> cells = q.getResultList();
		return cells.get(0);
	}

	public NEVersion getByNE(String ne) {
		Query q = em.createQuery("select n from NEVersion n where n.ne = :ne",
				NEVersion.class);
		q.setParameter("ne", ne);
		List<NEVersion> nes = q.getResultList();
		return nes.get(0);
	}

	public IMSI getByIMSI(Long imsi) {
		Query q = em.createQuery("select i from IMSI i where i.imsi = :imsi",
				IMSI.class);
		q.setParameter("imsi", imsi);
		List<IMSI> imsis = q.getResultList();
		return imsis.get(0);
	}

	public Duration getByDuration(Integer duration) {
		Query q = em.createQuery(
				"select d from Duration d where d.duration = :duration",
				Duration.class);
		q.setParameter("duration", duration);
		List<Duration> durations = q.getResultList();
		return durations.get(0);
	}

	public EventCause getByEventCause(Integer event) {
		Query q = em.createQuery(
				"select e from EventCause e where e.cause = :event",
				EventCause.class);
		q.setParameter("event", event);
		List<EventCause> causes = q.getResultList();
		return causes.get(0);
	}

	public EventId getByEventId(Integer eventId) {
		Query q = em.createQuery(
				"select e from EventId e where e.eventId = :eventId",
				EventId.class);
		q.setParameter("eventId", eventId);
		List<EventId> events = q.getResultList();
		return events.get(0);
	}

	public MCC getByMCC(Integer mcc) {
		Query q = em.createQuery("select m from MCC m where m.mcc = :mcc",
				MCC.class);
		q.setParameter("mcc", mcc);
		List<MCC> mccs = q.getResultList();
		return mccs.get(0);
	}

	public MNC getByMNC(Integer mnc) {
		Query q = em.createQuery("select m from MNC m where m.mnc = :mnc",
				MNC.class);
		q.setParameter("mnc", mnc);
		List<MNC> mncs = q.getResultList();
		return mncs.get(0);
	}

	public UE getByTac(Integer tac) {
		Query q = em.createQuery("select u from UE u where u.tac = :tac",
				UE.class);
		q.setParameter("tac", tac);
		List<UE> tacs = q.getResultList();
		return tacs.get(0);
	}
}