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

import com.dao.MNCDAO;
import com.entity.MNC;
<<<<<<< HEAD
import com.serviceInterfaces.MNCServiceLocal;

@Stateless
=======

@Stateful
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public class MNCServiceEJB implements MNCServiceLocal {

	@EJB
	private MNCDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<MNC> getAllMNC() {
		return dao.getMNC();
	}
<<<<<<< HEAD

=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}
