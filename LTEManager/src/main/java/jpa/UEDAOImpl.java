package jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import dao.UEDAO;
import entities.UE;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class UEDAOImpl implements UEDAO {

	@PersistenceContext
	private EntityManager em;

	public Collection<UE> getUE() {
		Query q = em.createQuery("select u from UE u");
		return q.getResultList();
	}

	public UE getByTac(Integer tac) {
		Query q = em.createQuery("select u from UE u where u.tac =" + tac,
				UE.class);
		List<UE> ul = q.getResultList();
		return ul.get(0);
	}
}