package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.NEVersionDAO;
import com.entity.NEVersion;

@Stateless
@Local
<<<<<<< HEAD

=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@SuppressWarnings("unchecked")
public class NEVersionDAOImpl implements NEVersionDAO {

	@PersistenceContext
	private EntityManager em;

<<<<<<< HEAD
	
	public Collection<NEVersion> getNEVersion() {
		Query q = em.createQuery("select n from NEVersion n left join fetch n.faultList");
		return q.getResultList();

	}
	public NEVersion getByNE(Integer ne){
		Query q = em.createQuery("select n from NEVersion n where n.ne = "+ne +" left join fetch n.faultList", NEVersion.class);
		List<NEVersion> nes = q.getResultList();
		return nes.get(0);
	}
	public void createNEVersion(Integer neId) {
		NEVersion ne = new NEVersion(neId);
		em.persist(ne);
	}
=======
	public Collection<NEVersion> getNEVersion() {
		Query q = em.createQuery("select n from NEVersion n");
		return q.getResultList();
	}

	public NEVersion getByNE(String ne) {
		Query q = em.createQuery("select n from NEVersion n where n.ne = :ne",
				NEVersion.class);
		q.setParameter("ne", ne);
		List<NEVersion> nes = q.getResultList();
		return nes.get(0);
	}

>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}