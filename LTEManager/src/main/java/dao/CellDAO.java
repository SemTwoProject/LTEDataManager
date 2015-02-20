package dao;

import javax.ejb.Local;

import entities.CellHier;
import java.util.Collection;
@Local
public interface CellDAO {

	Collection<CellHier> getCell();
	CellHier getByCellId(Integer cellId);
}