package com.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.entity.MNC;
import com.serviceInterfaces.MNCServiceLocal;

@Path("/mnc")
public class MNCRest {

	@EJB
	private MNCServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<MNC> getMNC() {
		return service.getAllMNC();
	}
}
