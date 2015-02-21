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
				.createQuery("select c from CellHier c left join fetch c.faultList");
		return q.getResultList();
	}

	public CellHier getByCellId(Integer cellId) {
		Query q = em.createQuery(
				"select cid from CellHier cid where cid.cellId = " + cellId
						+ " left join fetch cid.faultList", CellHier.class);
		List<CellHier> cells = q.getResultList();
		return cells.get(0);
	}
}