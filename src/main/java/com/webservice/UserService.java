package com.webservice;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qualifier.Resource;

@Path("/userservice")
public class UserService {

	@Inject
	private EntityManager em;

	// /rest/userservice/status
	@GET
	@Produces("text/html")
	@Path("status")
	public Response getStatus() {
		return Response.ok("<h1>LTE Data Manager is up !!!</h1>").build();
	}

	// /rest/userservice/list
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response listUsers() {
		String response = null;
		try {
			em = Resource.getEntityManager();
			Query query = em.createQuery("FROM com.entity.User");
			List<User> list = query.getResultList();
			em.close();
			response = toJSONString(list);
		} catch (Exception err) {
			response = "{\"status\":\"401\","
					+ "\"message\":\"No content found \""
					+ "\"developerMessage\":\"" + err.getMessage() + "\"" + "}";
			return Response.status(401).entity(response).build();

		}
		return Response.ok(response).build();
	}

	public String toJSONString(Object object) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setDateFormat("yyyy-mm-dd'T'HH:mm:ss.SSS'Z'");

		Gson gson = gsonBuilder.create();
		return gson.toJson(object);
	}
}