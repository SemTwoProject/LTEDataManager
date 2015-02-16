package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import dao.ExcelDAO;

@Stateless
@Local
public class ExcelServiceEJB implements ExcelServiceLocal {

	@EJB
	private ExcelDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createDuration(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createCell(file);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createIMSI(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createIMSI(file);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createCell(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createCell(file);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createInputMode(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createInputMode(file);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createOSType(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createOSType(file);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createNEVersion(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createNEVersion(file);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createUEType(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createUEType(file);

	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createMCC(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createMCC(file);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createFailure(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createFailure(file);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createEventId(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createEventId(file);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createMNC(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createMNC(file);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createEventCause(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createEventCause(file);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createUE(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createUE(file);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createFault(File file) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createFault(file);

	}
}