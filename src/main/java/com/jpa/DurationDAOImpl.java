package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.DurationDAO;
import com.entity.Duration;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class DurationDAOImpl implements DurationDAO {

	@PersistenceContext
	private EntityManager em;

<<<<<<< HEAD
	
	public Collection<Duration> getDuration() {
		Query q = em.createQuery("select d from Duration d left join fetch d.faultList");
		return q.getResultList();
	}
	public void createDuration(Integer dur){
		Duration duration = new Duration(dur);
		em.persist(duration);
	}
	
	public Duration getByDuration(Integer duration){
		Query q = em.createQuery("select d from Duration d where d.duration = "+duration +" left join fetch d.faultList", Duration.class);
=======
	public Collection<Duration> getDuration() {
		Query q = em
				.createQuery("select d from Duration d");
		return q.getResultList();
	}
	public Duration getByDuration(Integer duration) {
		Query q = em.createQuery(
				"select d from Duration d where d.duration = :duration",
				Duration.class);
		q.setParameter("duration", duration);
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
		List<Duration> durations = q.getResultList();
		return durations.get(0);
	}
}