package com.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.io.*;

<<<<<<< HEAD
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
=======
<<<<<<< HEAD
import com.serviceInterfaces.ExcelServiceLocal;
=======
import com.service.ExcelServiceLocal;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
>>>>>>> 324425364305526399e910bc0c61b9a257e84f9f

@Path("/excel")
public class ExcelRest {

	@POST
	@Consumes("multipart/form-data")
	@Produces(MediaType.APPLICATION_JSON)
	public String put(InputStream stream) throws IOException {
		HSSFWorkbook workbook;
		System.out.println(stream.available());
		workbook = new HSSFWorkbook(stream);
		System.out.println(workbook.getNumberOfSheets());
		return workbook.getSheetName(0);

<<<<<<< HEAD
=======
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
>>>>>>> 324425364305526399e910bc0c61b9a257e84f9f
	}
}