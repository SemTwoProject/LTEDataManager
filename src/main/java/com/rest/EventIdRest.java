package com.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

<<<<<<< HEAD
import com.entity.EventId;
import com.serviceInterfaces.EventIdServiceLocal;
=======
import com.service.EventIdServiceLocal;
import com.entity.EventId;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68

@Path("/eventid")
public class EventIdRest {

	@EJB
	private EventIdServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
<<<<<<< HEAD
	public Collection<EventId> getEventId() {
=======
	public Collection<EventId> getAllEventId() {
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
		return service.getAllEventId();
	}
}