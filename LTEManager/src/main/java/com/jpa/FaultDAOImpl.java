package com.jpa;

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

	//@Temporal(TemporalType.TimeStamp)

	public Collection<Fault> getFault() {
		Query q = em.createQuery("select ft from Fault ft");
		return q.getResultList();
	}

	public Fault getById(Integer id) {
		Query q = em.createQuery("select f from Fault f where f.id ='" + id
				+ "'", Fault.class);
		List<Fault> faults = q.getResultList();
		return faults.get(0);
	}

	public Collection<Fault> getFaultByIMSI(Long imsi) {
		Query q = em.createQuery("select f from Fault f where f.imsi = :imsi",
				Fault.class).setParameter("imsi", imsi);
		List<Fault> faults = q.getResultList();
		return faults;
	}
}