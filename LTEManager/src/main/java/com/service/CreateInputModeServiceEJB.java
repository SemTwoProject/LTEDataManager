package com.service;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.dao.ExcelDAO;
import com.dao.InputModeDAO;
import com.jpa.ExcelReadImpl;

@Stateless
@Local
public class CreateInputModeServiceEJB implements CreateInputModeServiceLocal {

	@EJB
	private InputModeDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createInputMode() {
		ExcelDAO excel = new ExcelReadImpl();
		try {
			dao.createInputMode(excel.createInputMode());
		} catch (InvalidFormatException | IOException e) {
			e.getMessage();
		}
	}
	

}