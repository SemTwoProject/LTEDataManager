<<<<<<< HEAD
package com.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
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
	public EventCause getEventCause() {
		return service.getAllEventCause(10);
	}
}
=======
package com.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
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
	public EventCause getEventCause() {
		return service.getAllEventCause(10);
	}
}
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
