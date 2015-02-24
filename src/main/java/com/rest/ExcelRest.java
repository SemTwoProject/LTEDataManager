package com.rest;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.commons.fileupload.FileUpload;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.service.ExcelServiceLocal;

@Path("/excel")
public class ExcelRest {

	@EJB
	private ExcelServiceLocal service;

	@POST
	@Path("/upload")
	@Consumes("multipart/form-data")
	public void createFromExcel(@MultipartForm FileUpload form)
			throws InvalidFormatException, FileNotFoundException, IOException {

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