package jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.UETypeDAO;
import entities.UEType;

@Stateless
@Local
public class UETypeDAOImpl implements UETypeDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<UEType> getUEType() {
		Query q = em.createQuery("select ut from UEType ut left join fetch ut.ueList");
		return q.getResultList();

	}
	public UEType getByUEType(String ue){
		Query q = em.createQuery("select ut from UEType ut where ut.ueType = "+ue +" left join fetch ut.ueList", UEType.class);
		List<UEType> types = q.getResultList();
		return types.get(0);
	}
	public void createUEType(String ueType) {
		UEType ue = new UEType(ueType);
		em.persist(ue);
		
	}
}