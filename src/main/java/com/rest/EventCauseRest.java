package com.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.entity.EventCause;
import com.interfaces.EventCauseServiceLocal;

@Path("/eventcause")
public class EventCauseRest {

	@EJB
	private EventCauseServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public EventCause getEventCause() {
		return service.getAllEventCause(10);
	}
}
