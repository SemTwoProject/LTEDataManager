package com.rest;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.FaultServiceLocal;
import java.util.Collection;

@Path("/fault")
public class FaultRest {

	@EJB
	private FaultServiceLocal service;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Object> getFaultByIMSI(
			@FormParam("imsi") Long imsi) {
		return service.getFaultByIMSI(imsi);
		
	}
	
	/*@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Object> getTotalFaultsAndDurationPerIMSI(
			Timestamp startdate, Timestamp enddate)
	{
		return service.getTotalFaultsAndDurationPerIMSI(startdate, enddate);
	}*/
}