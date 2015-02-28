package com.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ejb.Local;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

@Local
public interface ExcelDAO {

	// are not dependent on the creation of parent entity
	public void createCell(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createDuration(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createIMSI(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createOSType(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException;
	
	public void createInputMode(HSSFWorkbook wb) throws InvalidFormatException,
	FileNotFoundException, IOException;

	public void createNEVersion(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createUEType(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createMCC(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createFailure(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createEventId(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException;

	// are child dependents
	public void createMNC(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createEventCause(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createUE(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createFault(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException;
}