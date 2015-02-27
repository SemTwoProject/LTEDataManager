package com.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

<<<<<<< HEAD
import com.entity.UEType;
import com.serviceInterfaces.UETypeServiceLocal;
=======
import com.service.UETypeServiceLocal;
import com.entity.UEType;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68

@Path("/uetype")
public class UETypeRest {

	@EJB
	private UETypeServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<UEType> getMCC() {
		return service.getAllUEType();
	}
}