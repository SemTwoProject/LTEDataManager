package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.MCCDAO;
import com.entities.MCC;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class MCCDAOImpl implements MCCDAO {

	@PersistenceContext
	private EntityManager em;

	
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
}