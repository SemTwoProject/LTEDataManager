package com.rest;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.interfaces.UserService;

@Path("/users")
//@Table(name="users")
public class UserREST {

	@Inject
	private UserService service;
	
		// /rest/users/status
		@GET
		@RolesAllowed("System Administrator")
		@Produces("text/html")
		@Path("status")
		public Response getStatus() {
			return Response.ok("<h1>LTE Data Manager is up !!!</h1>").build();
		}
		
		// /rest/users/adduser
		@POST
		@RolesAllowed("System Administrator")
		@Produces(MediaType.APPLICATION_JSON)
		@Path("adduser")
		public void addUser(User user){
			service.addToUserDatabase(user);
		}

		// /rest/user/list
		@GET
		@RolesAllowed("System Administrator")
		@Produces(MediaType.APPLICATION_JSON)
		@Path("list")
		public Response listUsers() {
			String response = null;
			try {
				response = toJSONString(service.getAllUsersInDatabase());
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
