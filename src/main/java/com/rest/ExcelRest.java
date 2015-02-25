package com.rest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.service.ExcelServiceLocal;

@Path("/excel")
public class ExcelRest {

	@EJB
	private ExcelServiceLocal service;

	@POST
	@Consumes("multipart/form-data")
	public void createFromExcel(@Context HttpServletRequest req, @MultipartForm FileUpload form)
			throws InvalidFormatException, FileNotFoundException, IOException {

		ServletFileUpload upload = new ServletFileUpload();

		// Parse the request
		try {
			FileItemIterator iter = upload.getItemIterator(req);
			FileItemStream item = iter.next();
		    String name = item.getFieldName();
		    InputStream stream = item.openStream();
		    System.out.println("File Name: "+name);
		    
		    service.createCell(stream);
			service.createDuration(stream);
			service.createEventId(stream);
			service.createFailure(stream);
			service.createIMSI(stream);
			service.createMCC(stream);
			service.createNEVersion(stream);
			service.createOSType(stream);
			service.createUEType(stream);
			service.createEventCause(stream);
			service.createMNC(stream);
			service.createUE(stream);
			service.createFault(stream);
			
			

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		
	}
}