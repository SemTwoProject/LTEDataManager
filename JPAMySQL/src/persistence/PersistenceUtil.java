package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Capability;

public class PersistenceUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("DataSet");

	public static void persist(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
	}

	public static void remove(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Object mergedEntity = em.merge(entity);
		em.remove(mergedEntity);
		em.getTransaction().commit();
		em.close();
	}

	public static Object merge(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		entity = em.merge(entity);
		em.getTransaction().commit();
		em.close();
		return entity;
	}

	public static EntityManager createEM() {
		return emf.createEntityManager();
	}

	public static List<Capability> findAllCapabilities() {
		EntityManager em = emf.createEntityManager();
		List<Capability> capabilities = (List<Capability>) em.createNamedQuery(
				"Capability.findAllCapabilities").getResultList();
		em.close();

		return capabilities;

	}

	public static Capability findCapabilityByDescription(String description) {

		EntityManager em = emf.createEntityManager();
		List<Capability> capabilities = (List<Capability>) em
				.createNamedQuery("Capability.findByUsername")
				.setParameter("description", description).getResultList();
		em.close();

		if (capabilities.size() == 0)
			return null;
		else
			return capabilities.get(0);
	}

}