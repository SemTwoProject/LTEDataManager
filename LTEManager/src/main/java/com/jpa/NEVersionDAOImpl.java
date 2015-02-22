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
@SuppressWarnings("unchecked")
public class NEVersionDAOImpl implements NEVersionDAO {

	@PersistenceContext
	private EntityManager em;

	public void createNEVersions(){
		em.persist(new NEVersion("11B"));
		em.persist(new NEVersion("12A"));
	}
	public Collection<NEVersion> getNEVersion() {
		Query q = em
				.createQuery("select n from NEVersion n");
		return q.getResultList();

	}

	public NEVersion getByNE(String ne) {
		Query q = em.createQuery("select n from NEVersion n where n.ne = '" + ne+"'", NEVersion.class);
		List<NEVersion> nes = q.getResultList();
		return nes.get(0);
	}
}