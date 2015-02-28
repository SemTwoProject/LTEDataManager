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

import com.dao.NEVersionDAO;
import com.entity.NEVersion;
<<<<<<< HEAD
import com.serviceInterfaces.NEVersionServiceLocal;

@Stateless
=======

@Stateful
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public class NEVersionServiceEJB implements NEVersionServiceLocal {

	@EJB
	private NEVersionDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<NEVersion> getAllNEVersion() {
		return dao.getNEVersion();
	}
<<<<<<< HEAD

=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}
