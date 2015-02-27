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
import com.entity.MNC;
import com.serviceInterfaces.MNCServiceLocal;
=======
import com.service.MNCServiceLocal;
import com.entity.MNC;

import java.util.Collection;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68

@Path("/mnc")
public class MNCRest {

	@EJB
	private MNCServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<MNC> getMNC() {
		return service.getAllMNC();
	}
}
