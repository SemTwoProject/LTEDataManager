package com.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.MCCServiceLocal;
import com.entity.MccMnc;

@Path("/mcc")
public class MCCRest {

	@EJB
	private MCCServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<MccMnc> getMCC() {
		return service.getAllMCC();
	}
}