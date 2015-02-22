package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.IMSIDAO;
import com.entity.IMSI;

@Stateful
@Local
@SuppressWarnings("unchecked")
public class IMSIDAOImpl implements IMSIDAO {

	@PersistenceContext
	private EntityManager em;

	public void createIMSIs(){
		IMSI imsi;
		imsi = new IMSI(344930000000011L);
		em.persist(imsi);
		imsi = new IMSI(310560000000012L);
		em.persist(imsi);
		imsi = new IMSI(310560000000013L);
		em.persist(imsi);
	}

	public Collection<IMSI> getIMSI() {
		Query q = em
				.createQuery("select I from IMSI I");
		return q.getResultList();

	}

	public IMSI getByIMSI(Long imsi) {
		Query q = em.createQuery("select I from IMSI I where I.imsi = '" + imsi+"'",
				IMSI.class);
		List<IMSI> imsis = q.getResultList();
		return imsis.get(0);
	}
}