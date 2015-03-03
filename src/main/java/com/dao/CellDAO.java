package com.dao;

import javax.ejb.Local;

import com.entity.CellHier;
import java.util.Collection;
@Local
public interface CellDAO {

	Collection<CellHier> getCell();
	CellHier getByCellId(Integer cellId);
}