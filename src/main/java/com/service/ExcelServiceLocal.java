package com.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public interface ExcelServiceLocal {
	
	void createCell(HSSFWorkbook wb) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createMccMnc(HSSFWorkbook wb) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createFailure(HSSFWorkbook wb) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createEventCause(HSSFWorkbook wb) throws InvalidFormatException,
			FileNotFoundException, IOException;

	void createUE(HSSFWorkbook wb) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createFault(HSSFWorkbook wb) throws InvalidFormatException, FileNotFoundException,
	IOException;
}