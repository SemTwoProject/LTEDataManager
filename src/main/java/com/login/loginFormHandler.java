package com.login;

import java.io.IOException;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.entity.User;
<<<<<<< HEAD
import com.serviceInterfaces.UserService;
=======
import com.interfaces.UserService;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68

@Path("/login")
@PermitAll
public class loginFormHandler {

	@Inject
	private UserService service;

	@POST
	@PermitAll
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void checkLogin(@FormParam("username") String username,@FormParam("password") String password,@Context HttpServletResponse response, @Context HttpServletRequest request) throws IOException{
		String authLevel = null;

		User user = service.checkLoginDetails(username,password);
		authLevel = user.getUserType(); 

<<<<<<< HEAD
		/*if (authLevel == null){
			response.sendRedirect(response.encodeRedirectURL("/LTEDataManager/login.html"));

		}
		else {*/
			response.sendRedirect("/LTEDataManager/home/");
		//}
=======
		if (authLevel == null){
			response.sendRedirect(response.encodeRedirectURL("/LTEDataManager/login.html"));

		}
		else {
			response.sendRedirect("/LTEDataManager/home/");
		}
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
	}
}
