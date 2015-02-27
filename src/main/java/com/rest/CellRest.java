package com.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

<<<<<<< HEAD
import com.entity.CellHier;
import com.serviceInterfaces.CellServiceLocal;
=======
import com.service.CellServiceLocal;
import com.entity.CellHier;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68

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