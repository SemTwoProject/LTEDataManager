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

<<<<<<< HEAD
	@PersistenceContext private EntityManager em;
	
	public Collection<CellHier> getCell() {
		Query q = em.createQuery("select c from CellHier c left join fetch c.faultList");
		return q.getResultList();
	}
	public void createCellHier(Integer cellId, Long hier3_id, Long hier32_id, Long hier321_id) {
		CellHier cell = new CellHier(cellId,hier3_id,hier32_id,hier321_id);
		em.persist(cell);
	}
	public CellHier getByCellId(Long cellId){
		Query q = em.createQuery("select cid from CellHier cid where cid.cellId = "+cellId +" left join fetch cid.faultList", CellHier.class);
		List<CellHier> cells = q.getResultList();
=======
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
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
		return cells.get(0);
	}
}