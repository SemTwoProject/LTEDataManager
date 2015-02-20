package com.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.entity.Fault;
import com.serviceInterfaces.FaultServiceLocal;

@Path("/fault")
public class FaultRest {

	@EJB
	private FaultServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Fault> getFault() {
		return service.getAllFault();
	}
}
