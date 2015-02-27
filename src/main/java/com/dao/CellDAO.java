package com.dao;

<<<<<<< HEAD
import java.util.Collection;

import javax.ejb.Local;

import com.entity.CellHier;
=======
import javax.ejb.Local;

import com.entity.CellHier;
import java.util.Collection;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public interface CellDAO {

	Collection<CellHier> getCell();
<<<<<<< HEAD
	CellHier getByCellId(Long cellId);
	void createCellHier(Integer cellId, Long hier3_id, Long hier32_id, Long hier321_id);
=======
	CellHier getByCellId(Integer cellId);
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}