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

import com.dao.OSTypeDAO;
import com.entity.OSType;
<<<<<<< HEAD
import com.serviceInterfaces.OSTypeServiceLocal;

@Stateless
=======

@Stateful
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public class OSTypeServiceEJB implements OSTypeServiceLocal {

	@EJB
	private OSTypeDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<OSType> getAllOSType() {
		return dao.getOSType();
	}
<<<<<<< HEAD

=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}
