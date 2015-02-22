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

	public void createCells(){
		CellHier cell = new CellHier(4,4809532081614990000L,8226896360947470000L,1150444940909480000L);
		em.persist(cell);
		cell = new CellHier(5,7302598826786560000L, 7901152815458020000L,5509039050139200000L);
		em.persist(cell);
		cell = new CellHier(3842,229001099943031000L,4970937722532610000L,6079299740152730000L);
		em.persist(cell);
	}
	
	public Collection<CellHier> getCell() {
		Query q = em
				.createQuery("select c from CellHier c");
		return q.getResultList();
	}

	public CellHier getByCellId(Integer cellId) {
		Query q = em.createQuery(
				"select cid from CellHier cid where cid.cellId = '" + cellId
				+"'", CellHier.class);
		List<CellHier> cells = q.getResultList();
		return cells.get(0);
	}
}