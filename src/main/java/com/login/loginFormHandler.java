package com.login;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.entity.User;
import com.interfaces.UserService;

@Path("/login")
public class loginFormHandler {

	@Inject
	private UserService service;

	@POST
	@PermitAll
	@Consumes("multipart/form-data")
	public void checkLogin(@FormParam("username") String username,@FormParam("password") String password) throws URISyntaxException{
		String authLevel = null;
		URI location = new URI("localhost:8080/LTEDataManager/home.html");

		Collection<User> users = service.checkLoginDetails();
		for (User user:users){
			if ((user.getUsername().equals(username)) && (user.getPassword().equals(password))){
				authLevel = user.getUserType(); 
			}
		}

		if ((!authLevel.equals("System Administrator"))||(!authLevel.equals("Customer Service Rep"))
				||(!authLevel.equals("Support Engineer"))||(!authLevel.equals("Network Management"))
				|| username.equals(null)|| username.equals("")){
			Response.temporaryRedirect(location);
		}
	}
}
