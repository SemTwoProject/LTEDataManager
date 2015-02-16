package jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.MNCDAO;
import entities.MCC;
import entities.MNC;

@Stateless
@Local
public class MNCDAOImpl implements MNCDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
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