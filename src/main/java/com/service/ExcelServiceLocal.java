package com.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public interface ExcelServiceLocal {
	

	void createCell(InputStream in) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createDuration(InputStream in) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createIMSI(InputStream in) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createOSType(InputStream in) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createNEVersion(InputStream in) throws InvalidFormatException,
			FileNotFoundException, IOException;

	void createUEType(InputStream in) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createMCC(InputStream in) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createFailure(InputStream in) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createEventId(InputStream in) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createMNC(InputStream in) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createEventCause(InputStream in) throws InvalidFormatException,
			FileNotFoundException, IOException;

	void createUE(InputStream in) throws InvalidFormatException, FileNotFoundException,
			IOException;

	void createFault(InputStream in) throws InvalidFormatException, FileNotFoundException,
			IOException;
}