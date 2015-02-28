package com.rest;

<<<<<<< HEAD
import java.util.Collection;

=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

<<<<<<< HEAD
import com.entity.EventCause;
import com.serviceInterfaces.EventCauseServiceLocal;
=======
import com.service.EventCauseServiceLocal;
import com.entity.EventCause;

import java.util.Collection;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68

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
