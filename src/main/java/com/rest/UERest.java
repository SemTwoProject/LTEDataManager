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
import com.entity.UE;
import com.serviceInterfaces.UEServiceLocal;
=======
import com.service.UEServiceLocal;
import com.entity.UE;

import java.util.Collection;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68

@Path("/ue")
public class UERest {

	@EJB
	private UEServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<UE> getMNC() {
		return service.getAllUE();
	}
}
