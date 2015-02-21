package com.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.EventFailureIMSIServiceLocal;

@Path("/efimsi")
public class EventFailureIMSIRest {

	@EJB
	private EventFailureIMSIServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Object> getEventsAndFailuresByImsi(@FormParam("imsi") Long imsi) {
		return service.getAllEventsAndFailure(imsi);
	}
}