package jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.IMSIDAO;
import entities.IMSI;

@Stateful
@Local
@SuppressWarnings("unchecked")
public class IMSIDAOImpl implements IMSIDAO {

	@PersistenceContext
	private EntityManager em;

	public Collection<IMSI> getIMSI() {
		Query q = em
				.createQuery("select I from IMSI I left join fetch I.faultList");
		return q.getResultList();

	}

	public IMSI getByIMSI(Long imsi) {
		Query q = em.createQuery("select I from IMSI I where I.imsi = " + imsi,
				IMSI.class);
		List<IMSI> imsis = q.getResultList();
		return imsis.get(0);
	}
}