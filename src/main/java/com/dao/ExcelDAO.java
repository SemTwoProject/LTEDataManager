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

	public void createMccMnc(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createFailure(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException;

	// are child dependents

	public void createEventCause(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createUE(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createFault(HSSFWorkbook wb) throws InvalidFormatException,
	FileNotFoundException, IOException;
}