package com.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

<<<<<<< HEAD
import com.entity.Duration;
import com.serviceInterfaces.DurationServiceLocal;
=======
import com.service.DurationServiceLocal;
import com.entity.Duration;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68

@Path("/duration")
public class DurationRest {

	@EJB
	private DurationServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Duration> getDuration() {
		return service.getAllDuration();
<<<<<<< HEAD
	}
=======
	}	
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}