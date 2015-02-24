package com.rest;

import java.io.IOException;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
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
		@PermitAll
		@Produces("text/html")
		@Path("status")
		public Response getStatus() {
			return Response.ok("<h1>LTE Manager is up !!!</h1>").build();
		}
		
		// /rest/users/adduser
		@POST
		@PermitAll
		@Produces(MediaType.APPLICATION_FORM_URLENCODED)
		@Path("adduser")
		public void addUser(@FormParam("name") String name, @FormParam("username")String username, 
				@FormParam("password") String password,@FormParam("usertype") String userType,
				@Context HttpServletRequest request, @Context HttpServletResponse response){
			
			System.out.println(name);
			System.out.println(username);
			System.out.println(password);
			System.out.println(userType);
			
			User user = new User(name,username,password,userType);
			service.addToUserDatabase(user);
			
			try {
				response.sendRedirect(response.encodeRedirectURL("/LTEDataManager/home.html"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// /rest/users/list
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
