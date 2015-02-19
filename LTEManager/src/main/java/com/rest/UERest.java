package com.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.entities.UE;
import com.service.UEServiceLocal;

import java.util.Collection;

@Path("/ue")
public class UERest {

	@EJB
	private UEServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<UE> getMNC() {
		return service.getAllUE();
	}
}
