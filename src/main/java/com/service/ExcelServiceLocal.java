package com.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public interface ExcelServiceLocal {
	
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
	IOException;
}