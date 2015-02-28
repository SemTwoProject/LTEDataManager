package com.service;

import java.io.FileNotFoundException;
import java.io.IOException;
<<<<<<< HEAD
=======
<<<<<<< HEAD
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.dao.DurationDAO;
import com.dao.ExcelDAO;
import com.serviceInterfaces.ExcelServiceLocal;

@Stateless
=======
>>>>>>> 8f7e1d6638ac2ed1f6c7041de4efb9695698afdf

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.dao.ExcelDAO;

@Stateful
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public class ExcelServiceEJB implements ExcelServiceLocal {

	@EJB
	private ExcelDAO dao;
<<<<<<< HEAD
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
=======

<<<<<<< HEAD
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
=======
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
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68

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
>>>>>>> 8f7e1d6638ac2ed1f6c7041de4efb9695698afdf

	}
}