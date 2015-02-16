package jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.InputModeDAO;
import entities.InputMode;

@Stateless
@Local
public class InputModeDAOImpl implements InputModeDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<InputMode> getInputMode() {
		Query q = em.createQuery("select i from InputMode i left join fetch i.ueList");
		return q.getResultList();
	}
	public void createInputMode(String input){
		InputMode inputMode = new InputMode(input);
		em.persist(inputMode);
	}
	
	public InputMode getByInputMode(String input){
		Query q = em.createQuery("select i from InputMode i where i.inputMode = "+input+" left join fetch i.ueList", InputMode.class);
		List<InputMode> inputs = q.getResultList();
		return inputs.get(0);
	}
}