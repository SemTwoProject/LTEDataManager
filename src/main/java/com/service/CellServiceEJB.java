package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
<<<<<<< HEAD
import javax.ejb.Stateless;
=======
import javax.ejb.Stateful;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.CellDAO;
import com.entity.CellHier;
<<<<<<< HEAD
import com.serviceInterfaces.CellServiceLocal;

@Stateless
=======

@Stateful
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public class CellServiceEJB implements CellServiceLocal {

	@EJB
	private CellDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<CellHier> getAllCell() {
		return dao.getCell();
	}
<<<<<<< HEAD

=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}