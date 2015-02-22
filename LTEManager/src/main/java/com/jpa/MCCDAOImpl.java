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
	
	public void createMCCs(){
		MCC mcc;
		mcc = new MCC(238,"Denmark");
		em.persist(mcc);
		mcc = new MCC(240,"Sweden");
		em.persist(mcc);
		mcc = new MCC(302,"Canada");
		em.persist(mcc);
		mcc = new MCC(310,"United States of America");
		em.persist(mcc);
		mcc = new MCC(340,"Guadeloupe-France");
		em.persist(mcc);
		mcc = new MCC(344,"Antigua and Barbuda");
		em.persist(mcc);
		mcc = new MCC(405,"India");
		em.persist(mcc);
		mcc = new MCC(440,"Japan");
		em.persist(mcc);
		mcc = new MCC(505,"Australia");
		em.persist(mcc);
	}
	
	public Collection<MCC> getMCC() {
		Query q = em.createQuery("select m from MCC m");
		return q.getResultList();

	}
	public MCC getByMCC(Integer mcc){
		Query q = em.createQuery("select m from MCC  where m.mcc = '"+mcc+"'", MCC.class);
		List<MCC> mccs = q.getResultList();
		return mccs.get(0);
	}
}