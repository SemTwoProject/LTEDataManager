package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.UETypeDAO;
import com.entity.UEType;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class UETypeDAOImpl implements UETypeDAO {

	@PersistenceContext
	private EntityManager em;

	public void createUETypes(){
		UEType type;
		type = new UEType("M2M");
		em.persist(type);
		type = new UEType("PC");
		em.persist(type);
		type = new UEType("HANDHELD");
		em.persist(type);
		type = new UEType("(null)");
		em.persist(type);
	}
	public Collection<UEType> getUEType() {
		Query q = em
				.createQuery("select ut from UEType ut");
		return q.getResultList();

	}

	public UEType getByUEType(String ue) {
		Query q = em.createQuery("select ut from UEType ut where ut.ueType = '"
				+ ue +"'", UEType.class);
		List<UEType> types = q.getResultList();
		return types.get(0);
	}
}