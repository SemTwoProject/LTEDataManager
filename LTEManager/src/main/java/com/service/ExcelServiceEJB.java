package com.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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

	public void returnRow(File file) throws InvalidFormatException{
		dao.returnRow(file);
	}
	public void createCell() throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createCell();

	}

	public void createDuration() throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createDuration();

	}

	public void createIMSI() throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createIMSI();

	}

	public void createOSType() throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createOSType();

	}

	public void createNEVersion() throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createNEVersion();

	}

	public void createUEType() throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createUEType();

	}

	public void createMCC() throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createMCC();

	}

	public void createFailure() throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createFailure();

	}

	public void createEventId() throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createEventId();

	}

	public void createMNC() throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createMNC();

	}

	public void createEventCause() throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createEventCause();

	}

	public void createUE() throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createUE();

	}

	public void createFault() throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createFault();

	}
}