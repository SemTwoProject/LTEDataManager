package com.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.dao.ExcelDAO;

@Stateful
@Local
public class ExcelServiceEJB implements ExcelServiceLocal {

	@EJB
	private ExcelDAO dao;

	
	public void createCell(InputStream in) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createCell(in);

	}

	public void createDuration(InputStream in) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createDuration(in);

	}

	public void createIMSI(InputStream in) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createIMSI(in);

	}

	public void createOSType(InputStream in) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createOSType(in);

	}

	public void createNEVersion(InputStream in) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createNEVersion(in);

	}

	public void createUEType(InputStream in) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createUEType(in);

	}

	public void createMCC(InputStream in) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createMCC(in);

	}

	public void createFailure(InputStream in) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createFailure(in);

	}

	public void createEventId(InputStream in) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createEventId(in);

	}

	public void createMNC(InputStream in) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createMNC(in);

	}

	public void createEventCause(InputStream in) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createEventCause(in);

	}

	public void createUE(InputStream in) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createUE(in);

	}

	public void createFault(InputStream in) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createFault(in);

	}
}