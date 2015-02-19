package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.DurationDAO;
import com.entities.Duration;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class DurationDAOImpl implements DurationDAO {

	@PersistenceContext
	private EntityManager em;

	
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
		List<Duration> durations = q.getResultList();
		return durations.get(0);
	}
}