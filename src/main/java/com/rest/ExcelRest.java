package com.rest;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import java.io.*;

<<<<<<< HEAD
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.IOException;
import java.util.ArrayList;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.entity.NEVersion;
import com.service.ExcelServiceLocal;
=======
<<<<<<< HEAD
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
=======
<<<<<<< HEAD
import com.serviceInterfaces.ExcelServiceLocal;
=======
import com.service.ExcelServiceLocal;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
>>>>>>> 324425364305526399e910bc0c61b9a257e84f9f
>>>>>>> 8f7e1d6638ac2ed1f6c7041de4efb9695698afdf

@Path("/excel")
public class ExcelRest {

	@PersistenceContext
	private EntityManager em;
	
	@EJB
	ExcelServiceLocal service;
	
	NEVersion ne;
	HSSFDataFormatter formatter;
	HSSFSheet sheet;
    HSSFRow row; 
    HSSFCell cell;
    ArrayList<Cell> list = new ArrayList<Cell>();
	
	@POST
	@Consumes("multipart/form-data")
<<<<<<< HEAD
	public Response uploadFile(@MultipartForm Form form) {
		
		String fileName = "";
		try {
			HSSFWorkbook wb;
			wb = new HSSFWorkbook(new ByteArrayInputStream(form.getData()));
			fileName = wb.getSheetName(0);
			sheet = wb.getSheetAt(0);
			
			for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
				row = sheet.getRow(i);
				cell = row.getCell(0);
				list.add(cell);
			}
			System.out.println(list.size());
			wb.close();
			
		} catch (IOException //| InvalidFormatException
				e) {
			
			e.printStackTrace();
		}
		return Response.status(200)
			.entity("Uploaded file, starting with sheet : " + fileName).build();
=======
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
>>>>>>> 8f7e1d6638ac2ed1f6c7041de4efb9695698afdf
	}
}