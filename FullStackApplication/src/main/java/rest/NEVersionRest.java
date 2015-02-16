package rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import service.NEVersionServiceLocal;
import entities.NEVersion;

@Path("/neversion")
public class NEVersionRest {

	@EJB
	private NEVersionServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<NEVersion> getNEVersion() {
		return service.getAllNEVersion();
	}
}