package rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import service.IMSIServiceLocal;
import entities.IMSI;

@Path("/imsi")
public class IMSIRest {

	@EJB
	private IMSIServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<IMSI> getIMSI() {
		return service.getAllIMSI();
	}
}