package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.CellDAO;
import com.entity.CellHier;
import com.interfaces.CellServiceLocal;

@Stateful
@Local
public class CellServiceEJB implements CellServiceLocal {

	@EJB
	private CellDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<CellHier> getAllCell() {
		return dao.getCell();
	}
}