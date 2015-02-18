package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.InputModeDAO;
import com.entities.InputMode;

@Stateless
@Local
public class InputModeServiceEJB implements InputModeServiceLocal {

	@EJB
	private InputModeDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<InputMode> getAllInputMode() {
		return dao.getInputMode();
	}

}
