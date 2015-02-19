package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.UEDAO;
import com.entities.InputMode;
import com.entities.OSType;
import com.entities.UE;
import com.entities.UEType;

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