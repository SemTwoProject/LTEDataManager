package com.rest;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

<<<<<<< HEAD
import com.serviceInterfaces.ExcelServiceLocal;
=======
import com.service.ExcelServiceLocal;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68

@Path("/excel")
public class ExcelRest {

	@EJB
	private ExcelServiceLocal service;

	@GET
	@Produces("application/json")
<<<<<<< HEAD
	public void createFromExcel(
			) throws InvalidFormatException, FileNotFoundException, IOException{
		//service.createCell();
		service.createDuration();
		/*service.createEventId();
		service.createFailure();
		service.createIMSI();
		service.createMCC();
		service.createNEVersion();
		service.createOSType();
		service.createUEType();
		service.createEventCause();
		service.createMNC();
		service.createUE();
		service.createFault();*/
=======
	public  void createFromExcel() throws InvalidFormatException, FileNotFoundException, IOException {
		
			service.createCell();
			service.createDuration();
			service.createEventId();
			service.createFailure();
			service.createIMSI();
			service.createMCC();
			service.createNEVersion();
			service.createOSType();
			service.createUEType();
			service.createEventCause();
			service.createMNC();
			service.createUE();
			service.createFault();
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
	}
}