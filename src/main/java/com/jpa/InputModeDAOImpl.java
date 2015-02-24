package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.InputModeDAO;
import com.entity.InputMode;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class InputModeDAOImpl implements InputModeDAO {

	@PersistenceContext
	private EntityManager em;

	public Collection<InputMode> getInputMode() {
		Query q = em.createQuery("select i from InputMode i");
		return q.getResultList();
	}

	public InputMode getByInputMode(String input) {
		Query q = em.createQuery("select i from InputMode i where i.input = :input",
				InputMode.class);
		 q.setParameter("input", input);
		 List<InputMode> inputs = q.getResultList();
		return inputs.get(0);
	}
}