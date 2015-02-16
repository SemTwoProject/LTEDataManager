package jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.UEDAO;
import entities.InputMode;
import entities.OSType;
import entities.UE;
import entities.UEType;

@Stateless
@Local
public class UEDAOImpl implements UEDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<UE> getUE() {
		Query q = em.createQuery("select u from UE u");
		return q.getResultList();
	}
	public UE getByTac(Integer tac){
		Query q = em.createQuery("select u from UE u where u.tac ="+tac, UE.class);
		List<UE> ul = q.getResultList();
		return ul.get(0);
	}
	public void createUE(Integer tac, String marketingName,
			String manufacturer, String accessCapability, String model,
			String vendorName, OSType os, InputMode inputMode, UEType ueType) {
		UE ue = new UE(tac, marketingName, manufacturer,
			 accessCapability, model, vendorName,
			 os, inputMode, ueType);
		em.persist(ue);
		
	}
}