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

	public Collection<UEType> getUEType() {
		Query q = em
				.createQuery("select ut from UEType ut");
		return q.getResultList();

	}

	public UEType getByUEType(String ue) {
		Query q = em.createQuery("select u from UEType u where u.ueType = :ue",
				UEType.class);
		 q.setParameter("ue", ue);
		 List<UEType> uetypes = q.getResultList();
		return uetypes.get(0);
	}
}