package com.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.interfaces.ExcelServiceLocal;

@Path("/excel")
public class ExcelRest {

	@EJB
	private ExcelServiceLocal service;
	String fileName;

	@POST
	@Consumes("multipart/form-data")
	public Response uploadFile(@MultipartForm Form form)
			throws URISyntaxException {

		fileName = "c:\\excel\\upload.xls";
		try {
			writeFile(form.getData(), fileName);
			service.callAll();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		URI uri = new URI("../systemadmin.html");
		return Response.seeOther(uri).build();
	}

	
	
	private void writeFile(byte[] content, String filename) throws IOException {

		File file = new File(fileName);
		if (!file.exists()) {
			file.createNewFile();
		}

		FileOutputStream fileOut = new FileOutputStream(file);
		fileOut.write(content);
		fileOut.flush();
		fileOut.close();
	}
}