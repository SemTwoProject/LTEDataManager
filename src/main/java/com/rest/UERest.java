<<<<<<< HEAD
package com.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.UEServiceLocal;
import com.entity.UE;

import java.util.Collection;

@Path("/ue")
public class UERest {

	@EJB
	private UEServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<UE> getMNC() {
		return service.getAllUE();
	}
}
=======
package com.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.UEServiceLocal;
import com.entity.UE;

import java.util.Collection;

@Path("/ue")
public class UERest {

	@EJB
	private UEServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<UE> getUE() {
		return service.getAllUE();
	}
}
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
