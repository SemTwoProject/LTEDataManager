package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.InputModeDAO;
import com.entity.InputMode;

@Stateful
@Local
public class InputModeServiceEJB implements InputModeServiceLocal {

	@EJB
	private InputModeDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<InputMode> getAllInputMode() {
		return dao.getInputMode();
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createInputModes(){
		dao.createInputModes();
	}
}
