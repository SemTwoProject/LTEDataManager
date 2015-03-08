package com.rest;

import java.util.Collection;
import java.util.Date;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.entity.EventCause;
import com.service.FaultServiceLocal;

@Path("/fault")
public class FaultRest
{
	
	@EJB
	private FaultServiceLocal service;
	
	@POST
	@Path("/faultsbyimsi")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<EventCause> getFaultByIMSI(@FormParam("imsi") Long imsi)
	{
		return service.getFaultByIMSI(imsi);
		
	}
	
	@POST
	@Path("/totalfaults")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Object> getTotalFaultsAndDurationPerIMSI(
			@FormParam("startdate") Date startdate,
			@FormParam("enddate") Date enddate)
	{
		return service.getTotalFaultsAndDurationPerIMSI(startdate, enddate);
	}
	
}