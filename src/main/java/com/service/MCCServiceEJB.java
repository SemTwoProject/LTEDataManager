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

import com.dao.MCCDAO;
import com.entity.MCC;
<<<<<<< HEAD
import com.serviceInterfaces.MCCServiceLocal;

@Stateless
=======

@Stateful
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public class MCCServiceEJB implements MCCServiceLocal {

	@EJB
	private MCCDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<MCC> getAllMCC() {
		return dao.getMCC();
	}
<<<<<<< HEAD

=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}
