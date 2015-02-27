package com.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ejb.Local;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

@Local
public interface ExcelDAO {

	// are not dependent on the creation of parent entity
	public void createCell() throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createDuration() throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createIMSI() throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createOSType() throws InvalidFormatException,
			FileNotFoundException, IOException;
	
	public void createInputMode() throws InvalidFormatException,
	FileNotFoundException, IOException;

	public void createNEVersion() throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createUEType() throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createMCC() throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createFailure() throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createEventId() throws InvalidFormatException,
			FileNotFoundException, IOException;

	// are child dependents
	public void createMNC() throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createEventCause() throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createUE() throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createFault() throws InvalidFormatException,
			FileNotFoundException, IOException;
}