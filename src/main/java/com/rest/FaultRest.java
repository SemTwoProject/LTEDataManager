package com.rest;

import java.sql.Timestamp;
import java.util.Collection;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
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

import com.entity.EventCause;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.interfaces.FaultServiceLocal;

@Path("/fault")
public class FaultRest
{
	@EJB
	private FaultServiceLocal service;
	
	// rest/fault/faultsbyimsi - Story 4
	@POST
	@Path("/faultsbyimsi")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFaultByIMSI(@FormParam("imsi") Long imsi)
	{
		String newResponse = null;
		try
		{
			newResponse = toJSONString(service.getEventCausePerIMSI(imsi));
		}
		catch (Exception err)
		{
			newResponse = "{\"status\":\"401\","
					+ "\"message\":\"No content found \""
					+ "\"developerMessage\":\"" + err.getMessage() + "\"" + "}";
			return Response.status(401).entity(newResponse).build();
		}
		return Response.ok(newResponse).build();
	}
	
	// rest/fault/imsicount - Story 12
	@POST
	@PermitAll
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/imsicount")
	public Response getImsiCount(@FormParam("startdate") Timestamp startdate,
			@FormParam("enddate") Timestamp enddate,
			@FormParam("imsi") Long imsi)
	{
		
		String newResponse = null;
		
		try
		{
			newResponse = toJSONString(service.getIMSICount(startdate, enddate,
					imsi));
		}
		catch (Exception err)
		{
			newResponse = "{\"status\":\"401\","
					+ "\"message\":\"No content found \""
					+ "\"developerMessage\":\"" + err.getMessage() + "\"" + "}";
			return Response.status(401).entity(newResponse).build();
			
		}
		return Response.ok(newResponse).build();
	}
	
	// rest/fault/imsicausecodes - Story 17
	@POST
	@PermitAll
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/imsicausecodes")
	public Response getImsiCauseCodes(@FormParam("imsi") Long imsi)
	{
		
		String newResponse = null;
		
		try
		{
			newResponse = toJSONString(service.getCauseCodePerIMSI(imsi));
		}
		catch (Exception err)
		{
			newResponse = "{\"status\":\"401\","
					+ "\"message\":\"No content found \""
					+ "\"developerMessage\":\"" + err.getMessage() + "\"" + "}";
			return Response.status(401).entity(newResponse).build();
			
		}
		return Response.ok(newResponse).build();
	}
	
	// rest/fault/imsifailuresovertime -- Story 5
	@POST
	@PermitAll
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/imsifailuresovertime")
	public Response getAllIMSIFailuresOverTime(
			@FormParam("startdate") Timestamp startdate,
			@FormParam("enddate") Timestamp enddate)
	{
		
		String newResponse = null;
		
		try
		{
			newResponse = toJSONString(service.getIMSIFailureOverTime(
					startdate, enddate));
		}
		catch (Exception err)
		{
			newResponse = "{\"status\":\"401\","
					+ "\"message\":\"No content found \""
					+ "\"developerMessage\":\"" + err.getMessage() + "\"" + "}";
			return Response.status(401).entity(newResponse).build();
			
		}
		return Response.ok(newResponse).build();
		
	}
	
	// rest/fault/totalfaults -- Story 7
	@POST
	@PermitAll
	@Path("/totalfaults")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTotalFaultsAndDurationPerIMSI(
			@FormParam("startdate") Timestamp startdate,
			@FormParam("enddate") Timestamp enddate)
	{
		String newResponse = null;
		
		try
		{
			newResponse = toJSONString(service
					.getTotalFaultsAndDurationPerIMSI(startdate, enddate));
		}
		catch (Exception err)
		{
			newResponse = "{\"status\":\"401\","
					+ "\"message\":\"No content found \""
					+ "\"developerMessage\":\"" + err.getMessage() + "\"" + "}";
			return Response.status(401).entity(newResponse).build();
			
		}
		return Response.ok(newResponse).build();	
	}
	
		// rest/fault/toptenimsiovertime -- Story 18
		@POST
		@PermitAll
		@Path("/toptenimsiovertime")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getTopTenIMSIOverTime(
				@FormParam("startdate") Timestamp startdate,
				@FormParam("enddate") Timestamp enddate)
		{
			String newResponse = null;
			
			try
			{
				newResponse = toJSONString(service
						.getTopTenIMSIOverTime(startdate, enddate));
			}
			catch (Exception err)
			{
				newResponse = "{\"status\":\"401\","
						+ "\"message\":\"No content found \""
						+ "\"developerMessage\":\"" + err.getMessage() + "\"" + "}";
				return Response.status(401).entity(newResponse).build();
				
			}
			return Response.ok(newResponse).build();	
		}
	
	@GET
	@PermitAll
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/imsifailures")
	public Response getImsiPerFailure(@FormParam("failure") int failure)
	{
		String newResponse = null;
		failure = 0;
		
		try
		{
			newResponse = toJSONString(service.getImsiPerFailure(failure));
		}
		catch (Exception err)
		{
			newResponse = "{\"status\":\"401\","
					+ "\"message\":\"No content found \""
					+ "\"developerMessage\":\"" + err.getMessage() + "\"" + "}";
			return Response.status(401).entity(newResponse).build();
			
		}
		return Response.ok(newResponse).build();
		
	}
	
	public String toJSONString(Object object)
	{
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setDateFormat("yyyy-mm-dd'T'HH:mm:ss.SSS'Z'");
		
		Gson gson = gsonBuilder.create();
		return gson.toJson(object);
	}
	
}
