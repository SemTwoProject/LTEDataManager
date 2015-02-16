package jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.OSTypeDAO;
import entities.OSType;

@Stateless
@Local
public class OSTypeDAOImpl implements OSTypeDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
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
	}
}