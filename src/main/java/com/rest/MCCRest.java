package com.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

<<<<<<< HEAD
import com.entity.MCC;
import com.serviceInterfaces.MCCServiceLocal;
=======
import com.service.MCCServiceLocal;
import com.entity.MCC;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68

@Path("/mcc")
public class MCCRest {

	@EJB
	private MCCServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<MCC> getMCC() {
		return service.getAllMCC();
	}
}