package jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.CellDAO;
import entities.CellHier;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class CellDAOImpl implements CellDAO {

	@PersistenceContext private EntityManager em;
	
	public Collection<CellHier> getCell() {
		Query q = em.createQuery("select c from CellHier c left join fetch c.faultList");
		return q.getResultList();
	}
	public void createCellHier(Long cellId, Long hier3_id, Long hier32_id, Long hier321_id) {
		CellHier cell = new CellHier(cellId,hier3_id,hier32_id,hier321_id);
		em.persist(cell);
	}
	public CellHier getByCellId(Long cellId){
		Query q = em.createQuery("select cid from CellHier cid where cid.cellId = "+cellId +" left join fetch cid.faultList", CellHier.class);
		List<CellHier> cells = q.getResultList();
		return cells.get(0);
	}
}