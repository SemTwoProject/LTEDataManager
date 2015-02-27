package com.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.CellDAO;
import com.entity.CellHier;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class CellDAOImpl implements CellDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Collection<CellHier> getCell() {
		Query q = em
				.createQuery("select c from CellHier c");
		return q.getResultList();
	}
	
	public CellHier getByCellId(Integer cellId) {
		Query q = em.createQuery("select c from CellHier c where c.cellId = :cellId",
				CellHier.class);
		 q.setParameter("cellId", cellId);
		 List<CellHier> cells = q.getResultList();
		return cells.get(0);
	}
}