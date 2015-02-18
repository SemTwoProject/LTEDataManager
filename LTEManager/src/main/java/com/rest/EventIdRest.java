package com.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.entities.EventId;
import com.service.EventIdServiceLocal;

@Path("/eventid")
public class EventIdRest {

	@EJB
	private EventIdServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<EventId> getEventId() {
		return service.getAllEventId();
	}
}