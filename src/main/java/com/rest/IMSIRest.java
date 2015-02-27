package com.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

<<<<<<< HEAD
import com.entity.IMSI;
import com.serviceInterfaces.IMSIServiceLocal;
=======
import com.service.IMSIServiceLocal;
import com.entity.IMSI;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68

@Path("/imsi")
public class IMSIRest {

	@EJB
	private IMSIServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<IMSI> getIMSI() {
		return service.getAllIMSI();
	}
}