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

import com.dao.FailureDAO;
import com.entity.Failure;
<<<<<<< HEAD
import com.serviceInterfaces.FailureServiceLocal;

@Stateless
=======

@Stateful
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public class FailureServiceEJB implements FailureServiceLocal {

	@EJB
	private FailureDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<Failure> getAllFailure() {
		return dao.getFailure();
	}
<<<<<<< HEAD

=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}
