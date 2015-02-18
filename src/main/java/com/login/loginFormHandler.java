package com.login;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
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
	@Consumes("multipart/form-data")
	public void checkLogin(UserLogin login) throws URISyntaxException{
		String username = login.getUsername();
		String password = login.getPassword();
		String authLevel = null;
		URI location = new URI("/LTEDataManager/home.html");

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
