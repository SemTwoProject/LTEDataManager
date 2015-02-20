package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.MNCDAO;
import com.entity.MCC;
import com.entity.MNC;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class MNCDAOImpl implements MNCDAO {

	@PersistenceContext
	private EntityManager em;

	
	public Collection<MNC> getMNC() {
		Query q = em.createQuery("select m from MNC m");
		return q.getResultList();
	}
	
	public MNC getByMNC(Integer mnc){
		Query q = em.createQuery("select m from MNC m where m.mnc = "+mnc, MNC.class);
		List<MNC> mncs = q.getResultList();
		return mncs.get(0);
	}

	public void createMNC(Integer mnc, String operator, MCC mcc) {
		MNC mn = new MNC(mnc, operator, mcc);
		em.persist(mn);
		
	}
}