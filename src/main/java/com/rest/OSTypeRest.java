package com.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.entity.OSType;
import com.serviceInterfaces.OSTypeServiceLocal;

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