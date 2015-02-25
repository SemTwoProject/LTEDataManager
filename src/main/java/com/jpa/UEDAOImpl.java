package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.UEDAO;
import com.entity.InputMode;
import com.entity.OSType;
import com.entity.UE;
import com.entity.UEType;

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
		Query q = em.createQuery("select u from UE u where u.tac = :tac",
				UE.class);
		q.setParameter("tac", tac);
		List<UE> tacs = q.getResultList();
		return tacs.get(0);
	}

	public UEType getByUEType(String ue) {
		Query q = em.createQuery("select u from UEType u where u.ueType = :ue",
				UEType.class);
		q.setParameter("ue", ue);
		List<UEType> uetypes = q.getResultList();
		return uetypes.get(0);
	}

	public OSType getByOSType(String os) {
		Query q = em.createQuery("select o from OSType o where o.os = :os",
				OSType.class);
		q.setParameter("os", os);
		List<OSType> ostypes = q.getResultList();
		return ostypes.get(0);
	}

	public InputMode getByInputMode(String input) {
		Query q = em.createQuery(
				"select i from InputMode i where i.input = :input",
				InputMode.class);
		q.setParameter("input", input);
		List<InputMode> inputs = q.getResultList();
		return inputs.get(0);
	}
}