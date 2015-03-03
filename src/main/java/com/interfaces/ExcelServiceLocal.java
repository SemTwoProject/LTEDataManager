package com.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public interface ExcelServiceLocal {
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
			IOException;
}