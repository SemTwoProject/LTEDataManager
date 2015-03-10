package com.rest;

import java.util.Collection;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.entity.UE;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.interfaces.UEServiceLocal;

@Path("/ue")
public class UERest {

	@EJB
	private UEServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<UE> getUE() {
		return service.getAllUE();
	}
	
	@GET
	@PermitAll
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/modelfailures")
	public Response getModelFailures(@FormParam ("model") String model){
		String newResponse = null;
		model = "A53";
		
		try {
			newResponse = toJSONString(service.getEventCausePerModel(model));
		} catch (Exception err) {
			newResponse = "{\"status\":\"401\","
					+ "\"message\":\"No content found \""
					+ "\"developerMessage\":\"" + err.getMessage() + "\"" + "}";
			return Response.status(401).entity(newResponse).build();

		}
		return Response.ok(newResponse).build();
		
	}
	
	public String toJSONString(Object object) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setDateFormat("yyyy-mm-dd'T'HH:mm:ss.SSS'Z'");

		Gson gson = gsonBuilder.create();
		return gson.toJson(object);
	}


}
