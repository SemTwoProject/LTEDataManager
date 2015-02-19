package rest;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import service.ExcelServiceLocal;

@Path("/excel")
public class ExcelRest {

	@EJB
	private ExcelServiceLocal service;

	@GET
	//@Produces(MediaType.APPLICATION_JSON)
	public void createFromExcel(//@FormParam("file")String file
			) throws InvalidFormatException, FileNotFoundException, IOException{
		service.createCell();
		service.createDuration();
		service.createEventId();
		service.createFailure();
		service.createIMSI();
		service.createInputMode();
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