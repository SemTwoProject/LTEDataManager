package com.rest;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import java.io.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.service.ExcelServiceLocal;

@Path("/excel")
public class ExcelRest {

	@PersistenceContext
	private EntityManager em;

	@EJB
	private ExcelServiceLocal service;
	
	private HSSFWorkbook wb;

	@POST
	@Consumes("multipart/form-data")
	public Response uploadFile(@MultipartForm Form form) throws URISyntaxException {

		try {
			wb = new HSSFWorkbook(new ByteArrayInputStream(form.getData()));	
			service.createCell(wb);
			service.createFailure(wb);
			service.createMccMnc(wb);
			service.createEventCause(wb);
			service.createUE(wb);
			service.createFault(wb);
		} catch (IOException | InvalidFormatException e) {
			e.printStackTrace();
		}
		URI uri = new URI("../systemadmin.html");
		return Response.seeOther(uri).build();
	}
}