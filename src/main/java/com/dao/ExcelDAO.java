package com.dao;

import javax.ejb.Local;

@Local
public interface ExcelDAO {

	// are not dependent on the creation of parent entity
	public void createCell();

	public void createMccMnc();

	public void createFailure();

	// are child dependents

	public void createEventCause();

	public void createUE();

	public void createFault();
	
	public void callAll();
}