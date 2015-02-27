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
<<<<<<< HEAD
				.createQuery("select ut from UEType ut left join fetch ut.ueList");
=======
				.createQuery("select ut from UEType ut");
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
		return q.getResultList();

	}

	public UEType getByUEType(String ue) {
<<<<<<< HEAD
		Query q = em.createQuery("select ut from UEType ut where ut.ueType = "
				+ ue + " left join fetch ut.ueList", UEType.class);
		List<UEType> types = q.getResultList();
		return types.get(0);
	}

	public void createUEType(String ueType) {
		UEType ue = new UEType(ueType);
		em.persist(ue);

=======
		Query q = em.createQuery("select u from UEType u where u.ueType = :ue",
				UEType.class);
		 q.setParameter("ue", ue);
		 List<UEType> uetypes = q.getResultList();
		return uetypes.get(0);
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
	}
}