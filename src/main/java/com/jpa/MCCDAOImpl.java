<<<<<<< HEAD
package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.MCCDAO;
import com.entity.MccMnc;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class MCCDAOImpl implements MCCDAO {

	@PersistenceContext
	private EntityManager em;

	public Collection<MccMnc> getMCC() {
		Query q = em.createQuery("select m from MCC m");
		return q.getResultList();

	}

	public MccMnc getByMCC(Integer mcc) {
		Query q = em.createQuery("select m from MCC m where m.mcc = :mcc",
				MccMnc.class);
		q.setParameter("mcc", mcc);
		List<MccMnc> mccs = q.getResultList();
		return mccs.get(0);
	}
=======
package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.MCCDAO;
import com.entity.MccMnc;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class MCCDAOImpl implements MCCDAO {

	@PersistenceContext
	private EntityManager em;

	public Collection<MccMnc> getMCC() {
		Query q = em.createQuery("select m from MCC m");
		return q.getResultList();

	}

	public MccMnc getByMCC(Integer mcc) {
		Query q = em.createQuery("select m from MCC m where m.mcc = :mcc",
				MccMnc.class);
		q.setParameter("mcc", mcc);
		List<MccMnc> mccs = q.getResultList();
		return mccs.get(0);
	}
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
}