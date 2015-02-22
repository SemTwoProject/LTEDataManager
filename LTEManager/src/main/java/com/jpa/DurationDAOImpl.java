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

	public void createDurations() {
		Duration duration = new Duration(10000);
		if(!getDuration().contains(duration)){
			em.persist(duration);
		}else{
			em.refresh(duration);
		}
	}

	public Collection<Duration> getDuration() {
		Query q = em
				.createQuery("select d from Duration d");
		return q.getResultList();
	}

	public Duration getByDuration(Integer duration) {
		Query q = em.createQuery("select d from Duration d where d.duration = '"
				+ duration+"'", Duration.class);
		List<Duration> durations = q.getResultList();
		return durations.get(0);
	}
}