package com.rest;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import java.io.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;

import java.io.IOException;
import java.util.ArrayList;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.entity.NEVersion;
import com.service.ExcelServiceLocal;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import com.service.ExcelServiceLocal;

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

	}
}