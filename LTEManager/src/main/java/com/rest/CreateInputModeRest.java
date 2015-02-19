package com.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.service.CreateInputModeServiceLocal;

@Path("/in")
public class CreateInputModeRest {

	@EJB
	private CreateInputModeServiceLocal service;

	@GET
	@Produces("application/json")
	public void createInputMode() {
		service.createInputMode();
	}
}