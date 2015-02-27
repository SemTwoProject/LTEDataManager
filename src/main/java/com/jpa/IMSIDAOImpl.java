package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.IMSIDAO;
import com.entity.IMSI;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class IMSIDAOImpl implements IMSIDAO {

	@PersistenceContext
	private EntityManager em;

	public Collection<IMSI> getIMSI() {
<<<<<<< HEAD
		Query q = em.createQuery("select I from IMSI I left join fetch I.faultList");
		return q.getResultList();

	}
	public IMSI getByIMSI(Long imsi){
		Query q = em.createQuery("select I from IMSI I where I.imsi = "+imsi+" left join fetch I.faultList", IMSI.class);
		List<IMSI> imsis = q.getResultList();
		return imsis.get(0);
	}
	public void createIMSI(Long imsi) {
		IMSI im = new IMSI(imsi);
		em.persist(im);
		
	}
=======
		Query q = em
				.createQuery("select I from IMSI I");
		return q.getResultList();

	}

	public IMSI getByIMSI(Long imsi) {
		Query q = em.createQuery("select i from imsi i where i.imsi = :imsi",
				IMSI.class);
		q.setParameter("imsi", imsi);
		List<IMSI> imsis = q.getResultList();
		return imsis.get(0);
	}
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}