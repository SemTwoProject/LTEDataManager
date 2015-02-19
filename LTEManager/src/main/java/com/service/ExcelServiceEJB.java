package com.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.dao.DurationDAO;
import com.dao.ExcelDAO;
import com.jpa.ExcelReadImpl;

@Stateless
@Local
public class ExcelServiceEJB implements ExcelServiceLocal {

	@EJB
	private ExcelDAO dao;
	private DurationDAO dDao;
	ArrayList<Integer> durations = new ArrayList<Integer>();

	public void createDuration() throws InvalidFormatException{
		
	try {
		durations = dao.createDuration();
		dDao.createDuration(durations.get(0));
		if(!durations.isEmpty())
			for(Integer duration: durations){
				
			}
	} catch (InvalidFormatException | IOException e) {
		e.getMessage();
	}
	}

	public void createIMSI() throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createIMSI();

	}

	public void createCell() throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createCell();

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