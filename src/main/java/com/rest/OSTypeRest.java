package com.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

<<<<<<< HEAD
import com.entity.OSType;
import com.serviceInterfaces.OSTypeServiceLocal;
=======
import com.service.OSTypeServiceLocal;
import com.entity.OSType;

>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68

@Path("/ostype")
public class OSTypeRest {

	@EJB
	private OSTypeServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<OSType> getOSType() {
		return service.getAllOSType();
	}
}