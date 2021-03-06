package com.rest;

import java.sql.Timestamp;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/imsicausecodes")
	public Response getCauseCodesPerIMSI(@FormParam("imsi") Long imsi)
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
	
	
		// rest/fault/toptentotalfaults -- Story 7
		@POST
		@Path("/toptentotalfaults")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getTopTenTotalFaultsAndDurationPerIMSI(
				@FormParam("startdate") Timestamp startdate,
				@FormParam("enddate") Timestamp enddate)
		{
			String newResponse = null;
			
			try
			{
				newResponse = toJSONString(service
						.getTopTenTotalFaultsAndDurationPerIMSI(startdate, enddate));
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
	@Path("/toptenimsiovertime")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTopTenIMSIOverTime(
			@FormParam("startdate") Timestamp startdate,
			@FormParam("enddate") Timestamp enddate)
	{
		String newResponse = null;
		
		try
		{
			newResponse = toJSONString(service.getTopTenIMSIOverTime(startdate,
					enddate));
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
	
	// rest/fault/faultsbymodel -- Story 6
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/faultsbymodel")
	public Response getCountFaultsByModel(@FormParam("model") String model,
			@FormParam("startdate") Timestamp startDate,
			@FormParam("enddate") Timestamp endDate)
	{
		String newResponse = null;
		
		try
		{
			newResponse = toJSONString(service.getAmountOfCallFailuresPerModel(
					model, startDate, endDate));
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
	
	// rest/fault/imsiperfailurecode - Story 19
	@POST
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/imsiperfailurecode")
	public Response getImsiPerFailure(@FormParam("failure") int failureValue)
	{
		String newResponse = null;
		
		try
		{
			newResponse = toJSONString(service.getImsiPerFailure(failureValue));
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
	
	// rest/fault/toptenmnnmcncell - Story 15
	@POST
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/toptenmnnmcncell")
	public Response getTopTenMarketOperatorCell(
			@FormParam("startdate") Timestamp startDate,
			@FormParam("enddate") Timestamp endDate)
	{
		String newResponse = null;
		
		try
		{
			newResponse = toJSONString(service.getTopTenMarketOperatorCell(
					startDate, endDate));
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
	
	//Drill down
	@POST
	@PermitAll
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/modelfailures")
	public Response getModelFailures(@FormParam("model") String model)
	{
		String newResponse = null;
		
		try
		{
			newResponse = toJSONString(service.getEventCausePerModel(model));
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
	
	//Drill down
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/faultsformodeleventcombo")
	public Response getFaultsForModelCombo(@FormParam("model") String model, @FormParam("eventid") int eventid, @FormParam("causecode") int causecode)
	{
		String newResponse = null;
		try
		{
			newResponse = toJSONString(service.getFaultsForModelCombo(model, eventid, causecode));
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
	
	//Drill down
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/faultsforcell")
	public Response getFaultsForCell(@FormParam("country") String country,
			@FormParam("operator") String operator,
			@FormParam("cellid") int cellid)
	{
		String newResponse = null;
		try
		{
			newResponse = toJSONString(service.getFaultsForCell(country,
					operator, cellid));
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
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/models")
	public Response getModels(){
		String newResponse = null;
		try
		{
			newResponse = toJSONString(service.getAllModels());
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
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/failuredescriptions")
	public Response getFailureDescriptions(){
		String newResponse = null;
		try
		{
			newResponse = toJSONString(service.getFailureDescriptions());
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
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/imsis")
	public Response getIMSIS(){
		String newResponse = null;
		try
		{
			newResponse = toJSONString(service.getIMSIS());
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
		gsonBuilder.setDateFormat("yyyy-mm-dd' 'HH:mm:ss");
		
		Gson gson = gsonBuilder.create();
		return gson.toJson(object);
	}
	
}
