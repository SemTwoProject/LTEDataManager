package com.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public interface ExcelServiceLocal {
	

<<<<<<< HEAD
	void createCell(HSSFWorkbook wb) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createDuration(HSSFWorkbook wb) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createIMSI(HSSFWorkbook wb) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createOSType(HSSFWorkbook wb) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createNEVersion(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException;

	void createUEType(HSSFWorkbook wb) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createMCC(HSSFWorkbook wb) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createFailure(HSSFWorkbook wb) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createEventId(HSSFWorkbook wb) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createMNC(HSSFWorkbook wb) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createEventCause(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException;

	void createUE(HSSFWorkbook wb) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createFault(HSSFWorkbook wb) throws InvalidFormatException, FileNotFoundException,
=======
	void createCell() throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createDuration() throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createIMSI() throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createOSType() throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createNEVersion() throws InvalidFormatException,
			FileNotFoundException, IOException;

	void createUEType() throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createMCC() throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createFailure() throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createEventId() throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createMNC() throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createEventCause() throws InvalidFormatException,
			FileNotFoundException, IOException;

	void createUE() throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createFault() throws InvalidFormatException, FileNotFoundException,
>>>>>>> 8f7e1d6638ac2ed1f6c7041de4efb9695698afdf
			IOException;
}