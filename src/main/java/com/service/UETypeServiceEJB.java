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

import com.dao.UETypeDAO;
import com.entity.UEType;
<<<<<<< HEAD
import com.serviceInterfaces.UETypeServiceLocal;

@Stateless
=======

@Stateful
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public class UETypeServiceEJB implements UETypeServiceLocal {

	@EJB
	private UETypeDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<UEType> getAllUEType() {
		return dao.getUEType();
	}
<<<<<<< HEAD

=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}
