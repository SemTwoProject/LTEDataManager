package com.rest;

import java.util.Collection;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.entity.Failure;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.interfaces.FailureServiceLocal;

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