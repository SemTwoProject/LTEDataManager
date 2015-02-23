package com.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.DurationServiceLocal;
import com.entity.Duration;

@Path("/duration")
public class DurationRest {

	@EJB
	private DurationServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Duration> getDuration() {
		return service.getAllDuration();
	}	
}