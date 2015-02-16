package service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import dao.CellDAO;
import entities.CellHier;

@Stateless
@Local
public class CellServiceEJB implements CellServiceLocal {

	@EJB
	private CellDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<CellHier> getAllCell() {
		return dao.getCell();
	}

}
