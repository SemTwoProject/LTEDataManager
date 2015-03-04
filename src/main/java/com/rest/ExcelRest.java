<<<<<<< HEAD
package com.rest;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import java.io.IOException;
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
	public Response uploadFile(@MultipartForm Form form) {

		String fileName = "";
		try {
			wb = new HSSFWorkbook(new ByteArrayInputStream(form.getData()));
			service.createFailure(wb);
			service.createCell(wb);
			service.createMccMnc(wb);
			service.createEventCause(wb);
			service.createUE(wb);
			service.createFault(wb);
		} catch (IOException | InvalidFormatException e) {
			e.printStackTrace();
		}
		return Response.status(200)
				.entity("Uploaded file, starting with sheet : " + fileName)
				.build();
	}
=======
package com.rest;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import java.io.IOException;
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
	public Response uploadFile(@MultipartForm Form form) {

		String fileName = "";
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
		return Response.status(200)
				.entity("Uploaded file, starting with sheet : " + fileName)
				.build();
	}
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
}