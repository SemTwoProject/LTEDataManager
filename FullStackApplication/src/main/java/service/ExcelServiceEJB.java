package service;

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
	public void createDuration() throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createCell();

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createIMSI( ) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createIMSI();

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createCell( ) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createCell();

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createInputMode( ) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createInputMode();

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createOSType( ) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createOSType();

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createNEVersion( ) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createNEVersion();

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createUEType( ) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createUEType();

	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createMCC( ) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createMCC();

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createFailure( ) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createFailure();

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createEventId( ) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createEventId();

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createMNC( ) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createMNC();

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createEventCause( ) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createEventCause();

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createUE( ) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createUE();

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createFault( ) throws InvalidFormatException,
			FileNotFoundException, IOException {
		dao.createFault();

	}
}