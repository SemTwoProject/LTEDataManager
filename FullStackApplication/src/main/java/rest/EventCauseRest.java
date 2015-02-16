package rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import service.EventCauseServiceLocal;

import java.util.Collection;

import entities.EventCause;

@Path("/eventcause")
public class EventCauseRest {

	@EJB
	private EventCauseServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<EventCause> getEventCause() {
		return service.getAllEventCause();
	}
}
