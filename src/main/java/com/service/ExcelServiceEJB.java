package com.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.dao.ExcelDAO;

@Stateful
@Local
public class ExcelServiceEJB implements ExcelServiceLocal {

	@EJB
	private ExcelDAO dao;

	public void createCell(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createCell(wb);

	}

	public void createMccMnc(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createMccMnc(wb);

	}

	public void createFailure(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createFailure(wb);

	}

	public void createEventCause(HSSFWorkbook wb)
			throws InvalidFormatException, FileNotFoundException, IOException {
		dao.createEventCause(wb);

	}

	public void createUE(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createUE(wb);

	}

	public void createFault(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createFault(wb);
	}
}