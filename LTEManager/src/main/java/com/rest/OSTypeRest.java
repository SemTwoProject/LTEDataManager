package com.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.OSTypeServiceLocal;
import com.entity.OSType;


@Path("/ostype")
public class OSTypeRest {

	@EJB
	private OSTypeServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<OSType> getOSType() {
		return service.getAllOSType();
	}
	@POST
	public void createOSTypes(){
		service.createOSTypes();
	}
}