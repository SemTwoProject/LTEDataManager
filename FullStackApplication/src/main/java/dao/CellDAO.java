package dao;

import javax.ejb.Local;

import java.util.Collection;

import entities.CellHier;
@Local
public interface CellDAO {

	Collection<CellHier> getCell();
	CellHier getByCellId(Long cellId);
	void createCellHier(Long cellId, Long hier3_id, Long hier32_id, Long hier321_id);
}

