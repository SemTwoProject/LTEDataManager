package com.rest;

<<<<<<< HEAD
import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
=======
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

<<<<<<< HEAD
import com.entity.Fault;
import com.serviceInterfaces.FaultServiceLocal;
=======
import com.service.FaultServiceLocal;
import com.entity.Fault;

import java.util.Collection;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68

@Path("/fault")
public class FaultRest {

	@EJB
	private FaultServiceLocal service;
<<<<<<< HEAD

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Fault> getFault() {
		return service.getAllFault();
=======
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Object> getTotalFaultsAndDurationPerIMSI()
	{
		return service.getTotalFaultsAndDurationPerIMSI();
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
	}
}
