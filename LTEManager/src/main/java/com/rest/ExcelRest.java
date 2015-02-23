package com.rest;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.service.ExcelServiceLocal;

@Path("/excel")
public class ExcelRest {

	@EJB
	private ExcelServiceLocal service;

	@GET
	@Produces("application/json")
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
	}
}