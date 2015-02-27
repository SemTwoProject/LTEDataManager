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

import com.dao.UEDAO;
import com.entity.UE;
<<<<<<< HEAD
import com.serviceInterfaces.UEServiceLocal;

@Stateless
=======

@Stateful
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public class UEServiceEJB implements UEServiceLocal {

	@EJB
	private UEDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<UE> getAllUE() {
		return dao.getUE();
	}
<<<<<<< HEAD

=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}
