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

import com.dao.InputModeDAO;
import com.entity.InputMode;
<<<<<<< HEAD
import com.serviceInterfaces.InputModeServiceLocal;

@Stateless
=======

@Stateful
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public class InputModeServiceEJB implements InputModeServiceLocal {

	@EJB
	private InputModeDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<InputMode> getAllInputMode() {
		return dao.getInputMode();
	}
<<<<<<< HEAD

=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}
