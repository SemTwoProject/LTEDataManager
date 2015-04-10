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

	public void callAll(String fileName) {
		dao.callAll(fileName);
	}
}