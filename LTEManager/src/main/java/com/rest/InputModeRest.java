package com.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.entities.InputMode;
import com.service.InputModeServiceLocal;

@Path("/inputmode")
public class InputModeRest {

	@EJB
	private InputModeServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<InputMode> getInputMode() {
		return service.getAllInputMode();
	}
}