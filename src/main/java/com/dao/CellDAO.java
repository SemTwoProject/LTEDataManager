package com.dao;

import javax.ejb.Local;

import com.entity.CellHier;
import java.util.Collection;
@Local
public interface CellDAO {

	Collection<CellHier> getCell();
	Collection<CellHier> getByCellId(Integer cellId);
}