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
}