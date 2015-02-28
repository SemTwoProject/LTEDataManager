package com.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ejb.Local;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
<<<<<<< HEAD
=======
<<<<<<< HEAD

import com.entity.EventId;
import com.entity.MCC;
=======
import org.apache.poi.ss.usermodel.Cell;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
>>>>>>> 324425364305526399e910bc0c61b9a257e84f9f

@Local
public interface ExcelDAO {

	// are not dependent on the creation of parent entity
<<<<<<< HEAD
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
=======
<<<<<<< HEAD
	ArrayList<Integer> createCell( ) throws InvalidFormatException, FileNotFoundException, IOException;
	ArrayList<Integer> createHier3Id();
	ArrayList<Integer> createHier32Id();
	ArrayList<Integer> createHier321Id();
	
	ArrayList<Integer> createDuration() throws InvalidFormatException, FileNotFoundException, IOException;
	ArrayList<Integer> createIMSI( ) throws InvalidFormatException, FileNotFoundException, IOException;
	ArrayList<String> createOSType() throws InvalidFormatException, FileNotFoundException, IOException;
	ArrayList<String> createNEVersion() throws InvalidFormatException, FileNotFoundException, IOException;
	ArrayList<String> createUEType() throws InvalidFormatException, FileNotFoundException, IOException;
	
	ArrayList<Integer> createMCC() throws InvalidFormatException, FileNotFoundException, IOException;
	ArrayList<Integer> createCountry() throws InvalidFormatException, FileNotFoundException, IOException;
	
	ArrayList<Integer> createFailure() throws InvalidFormatException, FileNotFoundException, IOException;
	ArrayList<String> createFailureDescription();
	
	ArrayList<Integer> createEventId() throws InvalidFormatException, FileNotFoundException, IOException;
	// are child dependents
	ArrayList<Integer> createMNC() throws InvalidFormatException, FileNotFoundException, IOException;
	ArrayList<String> createOperator();
	ArrayList<MCC> createMNCMCCKey();
	
	ArrayList<Integer> createEventCause() throws InvalidFormatException, FileNotFoundException, IOException;
	ArrayList<String> createEventDescription();
	ArrayList<EventId> createEventCauseEventId();
	
	public void createUE() throws InvalidFormatException, FileNotFoundException, IOException;
	
	
	public void createFault()throws InvalidFormatException, FileNotFoundException, IOException;
=======
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
>>>>>>> 8f7e1d6638ac2ed1f6c7041de4efb9695698afdf
			FileNotFoundException, IOException;
<<<<<<< HEAD
=======
	
	ArrayList<Cell> selectColumnValue(int sheet, int column) throws InvalidFormatException;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68

>>>>>>> 324425364305526399e910bc0c61b9a257e84f9f
}