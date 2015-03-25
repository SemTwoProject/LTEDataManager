package com.login;

import java.net.URISyntaxException;
import java.util.Collection;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.entity.User;
import com.interfaces.UserServiceLocal;

@Path("/login")
@PermitAll
public class loginFormHandler {

	@Inject
	private UserServiceLocal service;

	@POST
	@Path("/auth")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String checkLogin(@FormParam("username") String username,
			@FormParam("password") String password) throws URISyntaxException {
		String authLevel = null;

		Collection<User> user = service.getUserByUsernameAndPassword(username, password);
		authLevel = user.iterator().next().getUserType(); 

		return authLevel;
//		if (authLevel == null) 
//		{
//			URI uri = new URI("../index.html");
//			return Response.seeOther(uri).build();
//		} 
//		else 
//		{
//			URI uri = new URI("../home.html");
//			return Response.seeOther(uri).build();
//		}
	}

}
