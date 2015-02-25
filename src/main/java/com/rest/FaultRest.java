package com.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.FaultServiceLocal;
import com.entity.Fault;

import java.util.Collection;

@Path("/fault")
public class FaultRest {

	@EJB
	private FaultServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Fault> getFault() {
		return service.getAllFault();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Collection<Object> getFaultByIMSI(
			@FormParam("imsi") Long imsi) {
		System.out.println("Rest: "+imsi);
		return service.getFaultByIMSI(imsi);
		
	}

}
