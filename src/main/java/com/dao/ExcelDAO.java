package com.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.Local;

import org.apache.commons.fileupload.FileUpload;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;

@Local
public interface ExcelDAO {

	// are not dependent on the creation of parent entity
	public void createCell(FileUpload form) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createDuration(FileUpload form) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createIMSI(FileUpload form) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createOSType(FileUpload form) throws InvalidFormatException,
			FileNotFoundException, IOException;
	
	public void createInputMode(FileUpload form) throws InvalidFormatException,
	FileNotFoundException, IOException;

	public void createNEVersion() throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createUEType(FileUpload form) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createMCC(FileUpload form) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createFailure(FileUpload form) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createEventId(FileUpload form) throws InvalidFormatException,
			FileNotFoundException, IOException;

	// are child dependents
	public void createMNC(FileUpload form) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createEventCause(FileUpload form) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createUE(FileUpload form) throws InvalidFormatException,
			FileNotFoundException, IOException;

	public void createFault(FileUpload form) throws InvalidFormatException,
			FileNotFoundException, IOException;
}