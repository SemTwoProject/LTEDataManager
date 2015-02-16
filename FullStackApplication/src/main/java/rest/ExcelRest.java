package rest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import service.ExcelServiceLocal;

@Path("/excel{file}")
public class ExcelRest {

	@EJB
	private ExcelServiceLocal service;
	@PUT
	@Consumes("application/vnd.ms-excel")
	public void createFromExcel(@PathParam("file") File file) throws InvalidFormatException, FileNotFoundException, IOException{
		service.createCell(file);
		service.createDuration(file);
		service.createEventId(file);
		service.createFailure(file);
		service.createIMSI(file);
		service.createInputMode(file);
		service.createMCC(file);
		service.createNEVersion(file);
		service.createOSType(file);
		service.createUEType(file);
		service.createEventCause(file);
		service.createMNC(file);
		service.createUE(file);
		service.createFault(file);
	}
}