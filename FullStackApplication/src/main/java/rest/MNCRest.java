package rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import service.MNCServiceLocal;

import java.util.Collection;

import entities.MNC;

@Path("/mnc")
public class MNCRest {

	@EJB
	private MNCServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<MNC> getMNC() {
		return service.getAllMNC();
	}
}
