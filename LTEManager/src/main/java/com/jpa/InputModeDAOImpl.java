package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.InputModeDAO;
import com.entities.InputMode;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class InputModeDAOImpl implements InputModeDAO {

	@PersistenceContext
	private EntityManager em;

	public Collection<InputMode> getInputMode() {
		Query q = em.createQuery("select i from InputMode i left join fetch i.ueList");
		return q.getResultList();
	}
	public void createInputMode(String input){
		InputMode inputMode = new InputMode(input);
		
		if (!getInputMode().contains(input)){
			em.persist(inputMode);
		}
		else {
			em.refresh(inputMode);
		}
	}
	
	public InputMode getByInputMode(String input){
		Query q = em.createQuery("select i from InputMode i where i.inputMode = "+input+" left join fetch i.ueList", InputMode.class);
		List<InputMode> inputs = q.getResultList();
		return inputs.get(0);
	}
}