package com.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

<<<<<<< HEAD
import com.entity.InputMode;
import com.serviceInterfaces.InputModeServiceLocal;
=======
import com.service.InputModeServiceLocal;
import com.entity.InputMode;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68

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