package com.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

<<<<<<< HEAD
import com.entity.Failure;
import com.serviceInterfaces.FailureServiceLocal;
=======
import com.service.FailureServiceLocal;
import com.entity.Failure;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68

@Path("/failure")
public class FailureRest {

	@EJB
	private FailureServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Failure> getFailure() {
		return service.getAllFailure();
	}
}