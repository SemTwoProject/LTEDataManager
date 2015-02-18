package com.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.entities.CellHier;
import com.service.CellServiceLocal;

@Path("/cell")
public class CellRest {

	@EJB
	private CellServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<CellHier> getCell() {
		return service.getAllCell();
	}
}