package com.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.io.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

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

	}
}