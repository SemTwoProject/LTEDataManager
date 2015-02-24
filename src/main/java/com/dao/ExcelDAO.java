package com.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.ejb.Local;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

@Local
public interface ExcelDAO {

	// are not dependent on the creation of parent entity
	public void createCell(InputStream form) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createDuration(InputStream form) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createIMSI(InputStream form) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createOSType(InputStream form) throws InvalidFormatException,
			FileNotFoundException, IOException;
	
	public void createInputMode(InputStream form) throws InvalidFormatException,
	FileNotFoundException, IOException;

	public void createNEVersion(InputStream form) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createUEType(InputStream form) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createMCC(InputStream form) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createFailure(InputStream form) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createEventId(InputStream form) throws InvalidFormatException,
			FileNotFoundException, IOException;

	// are child dependents
	public void createMNC(InputStream form) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createEventCause(InputStream form) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createUE(InputStream form) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createFault(InputStream form) throws InvalidFormatException,
			FileNotFoundException, IOException;
}