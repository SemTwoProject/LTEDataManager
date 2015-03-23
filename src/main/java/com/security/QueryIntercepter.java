/*package com.security;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethodInvoker;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.util.Base64;

import com.entity.User;
import com.interfaces.UserServiceLocal;


@Provider
public class QueryIntercepter implements ContainerRequestFilter {

	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static final String AUTHENTICATION_SCHEME = "Basic";
	private static final ServerResponse ACCESS_DENIED = new ServerResponse("You are not authorised to complete this action", 401, new Headers<Object>());
	private static final ServerResponse ACCESS_FORBIDDEN = new ServerResponse("This act is forbidden",403, new Headers<Object>());
	private static final ServerResponse SERVER_ERROR = new ServerResponse("SERVER ERROR", 500, new Headers<Object>());

	@EJB
	private UserServiceLocal service;

	public void filter(ContainerRequestContext requestContext){

		ResourceMethodInvoker methodInvoker = (ResourceMethodInvoker) requestContext.getProperty("org.jboss.resteasy.core.ResourceMethodInvoker");
		Method method = methodInvoker.getMethod();

		//Permit all once the @PermitAll is set
		if(!method.isAnnotationPresent(PermitAll.class)){

			//Deny all
			if(method.isAnnotationPresent(DenyAll.class)){
				requestContext.abortWith(ACCESS_FORBIDDEN);
				return;
			}

			//Get the request headers
			final MultivaluedMap<String, String> header = requestContext.getHeaders();

			final List<String> authorization = header.get(AUTHORIZATION_PROPERTY);

			//If there is no basic authorization present, deny access
			if(authorization == null || authorization.isEmpty()){
				requestContext.abortWith(ACCESS_DENIED);
				return;
			}

			//Get encoded username and password from the authorization 
			final String encodedUserPassword = authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");

			//Decode username and password 
			//Basic authentication encodes in Base 64
			//So Base 64 is used to decode the username and password
			String usernameAndPassword = null;
			try {
				usernameAndPassword = new String(Base64.decode(encodedUserPassword));
			} catch (IOException e) {
				//If decoding will not work a server error is thrown
				requestContext.abortWith(SERVER_ERROR);
				return;
			}

			//Split up the username and password 
			final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
			final String username = tokenizer.nextToken();
			final String password = tokenizer.nextToken();

			//Verify the method role type
			if(method.isAnnotationPresent(RolesAllowed.class))
			{
				//Take the role allowed from the @RolesAllowed annotation above the desired method
				RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
				//Using a HashSet as it may be possible that multiple user types can acess the method
				Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));
				System.out.println(rolesSet);

				//Is user valid?
				if( !isUserAllowed(username, password, rolesSet))
				{
					requestContext.abortWith(ACCESS_DENIED);
					return;
				}
			}
		}
	}

	private boolean isUserAllowed(final String username, final String password,	final Set<String> rolesSet) 
	{
		boolean isAllowed = false;
		String userRole = null;
		//check the login details of the user 
		//return the user role
		User user = service.checkLoginDetails(username,password);
		userRole = user.getUserType(); 

		//Step 2. Verify user role
		if(rolesSet.contains(userRole))
		{
			isAllowed = true;
		}
		return isAllowed;
	}

}	

*/