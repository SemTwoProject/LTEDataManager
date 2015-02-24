package com.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.FailureServiceLocal;
import com.entity.Failure;

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