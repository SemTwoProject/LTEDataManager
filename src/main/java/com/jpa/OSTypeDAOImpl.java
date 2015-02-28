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
<<<<<<< HEAD

	
	public Collection<OSType> getOSType() {
		Query q = em.createQuery("select o from OSType m left join fetch o.ueList");
		return q.getResultList();

	}
	public OSType getByOSType(String os){
		Query q = em.createQuery("select o from OSType o where o.os = "+os+" left join fetch o.ueList", OSType.class);
		List<OSType> oss = q.getResultList();
		return oss.get(0);
	}
	public void createOSType(String osType) {
		OSType os = new OSType(osType);
		em.persist(os);
=======
	
	public Collection<OSType> getOSType() {
		Query q = em
				.createQuery("select o from OSType o");
		return q.getResultList();

	}
	
	public OSType getByOSType(String os) {
		Query q = em.createQuery("select o from OSType o where o.os = :os",
				OSType.class);
		 q.setParameter("os", os);
		 List<OSType> ostypes = q.getResultList();
		return ostypes.get(0);
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
	}
}