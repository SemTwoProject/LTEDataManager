package com.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.Local;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.entity.EventId;
import com.entity.MCC;

@Local
public interface ExcelDAO {

	// are not dependent on the creation of parent entity
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

}