package rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import service.EventIdServiceLocal;
import entities.EventId;

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