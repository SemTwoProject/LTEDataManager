package com.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.EventCauseServiceLocal;
import com.entity.EventCause;

import java.util.Collection;

@Path("/eventcause")
public class EventCauseRest {

	@EJB
	private EventCauseServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<EventCause> getEventCause() {
		return service.getAllEventCause();
	}
	@POST
	public void createEventCause(){
		service.createEventCauses();
	}
}
