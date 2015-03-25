package com.service;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;

import com.dao.ExcelDAO;
import com.interfaces.ExcelServiceLocal;

@Stateful
@Local
public class ExcelServiceEJB implements ExcelServiceLocal {

	@EJB
	private ExcelDAO dao;

	public void createCell() {
		dao.createCell();
	}

	public void createMccMnc() {
		dao.createMccMnc();

	}

	public void createFailure() {
		dao.createFailure();

	}

	public void createEventCause() {
		dao.createEventCause();

	}

	public void createUE() {
		dao.createUE();

	}

	public void createFault() {
		dao.createFault();
	}

	public void callAll() {
		dao.callAll();
	}
}