package com.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.entity.UEType;
import com.serviceInterfaces.UETypeServiceLocal;

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