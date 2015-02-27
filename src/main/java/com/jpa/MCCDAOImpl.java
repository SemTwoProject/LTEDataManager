package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.MCCDAO;
import com.entity.MCC;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class MCCDAOImpl implements MCCDAO {

	@PersistenceContext
	private EntityManager em;

<<<<<<< HEAD
	
	public Collection<MCC> getMCC() {
		Query q = em.createQuery("select m from MCC m left join fetch m.mncOperators");
		return q.getResultList();

	}
	public MCC getByMCC(Integer mcc){
		Query q = em.createQuery("select m from MCC  where m.mcc = "+mcc+" m left join fetch m.mncOperators", MCC.class);
		List<MCC> mccs = q.getResultList();
		return mccs.get(0);
	}
	public void createMCC(Integer mccId, String description) {
		MCC mcc = new MCC(mccId, description);
		em.persist(mcc);
		
	}
=======
	public Collection<MCC> getMCC() {
		Query q = em.createQuery("select m from MCC m");
		return q.getResultList();

	}

	public MCC getByMCC(Integer mcc) {
		Query q = em.createQuery("select m from MCC m where m.mcc = :mcc",
				MCC.class);
		q.setParameter("mcc", mcc);
		List<MCC> mccs = q.getResultList();
		return mccs.get(0);
	}
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}