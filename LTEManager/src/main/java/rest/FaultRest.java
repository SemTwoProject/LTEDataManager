package rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import service.FaultServiceLocal;
import entities.Fault;

import java.util.Collection;

@Path("/fault")
public class FaultRest {

	@EJB
	private FaultServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Fault> getFault() {
		return service.getAllFault();
	}
}
