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

	public void createDuration(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createDuration(wb);

	}

	public void createIMSI(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createIMSI(wb);

	}

	public void createOSType(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createOSType(wb);

	}

	public void createNEVersion(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createNEVersion(wb);

	}

	public void createUEType(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createUEType(wb);

	}

	public void createMCC(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createMCC(wb);

	}

	public void createFailure(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createFailure(wb);

	}

	public void createEventId(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createEventId(wb);

	}

	public void createMNC(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createMNC(wb);

	}

	public void createEventCause(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException {
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