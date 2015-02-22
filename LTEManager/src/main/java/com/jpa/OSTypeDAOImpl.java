package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.OSTypeDAO;
import com.entity.OSType;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class OSTypeDAOImpl implements OSTypeDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void createOSTypes(){
		OSType os;
		os = new OSType("BLACKBERRY");
		em.persist(os);
		os = new OSType("IOS");
		em.persist(os);
		os = new OSType("(null)");
		em.persist(os);
	}

	public Collection<OSType> getOSType() {
		Query q = em
				.createQuery("select o from OSType o");
		return q.getResultList();

	}

	public OSType getByOSType(String os) {
		Query q = em.createQuery("select o from OSType o where o.os = '" + os
				+"'", OSType.class);
		List<OSType> oss = q.getResultList();
		return oss.get(0);
	}
}