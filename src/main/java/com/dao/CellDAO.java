package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.CellHier;
@Local
public interface CellDAO {

	Collection<CellHier> getCell();
	CellHier getByCellId(Long cellId);
	void createCellHier(Integer cellId, Long hier3_id, Long hier32_id, Long hier321_id);
}