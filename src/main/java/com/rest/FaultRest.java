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

	@POST
	@Path("/faultsbyimsi")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<EventCause> getFaultByIMSI(@FormParam("imsi") Long imsi)
	{
		return service.getFaultByIMSI(imsi);
	}
	

	// /rest/fault/imsicount
	@GET
	@PermitAll
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/imsicount")
	public Response getImsiCount(@FormParam("startDate") Timestamp startDate,
			@FormParam("endDate") Timestamp endDate,
			@FormParam("searchimsi") Long searchimsi,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {

		String newResponse = null;
		searchimsi = 191911000516761L;
		startDate = Timestamp.valueOf("2013-02-19 00:00:00");
		endDate = Timestamp.valueOf("2013-02-22 00:00:00");

		try {
			newResponse = toJSONString(service.getIMSICount(startDate,endDate,searchimsi));
		} catch (Exception err) {
			newResponse = "{\"status\":\"401\","
					+ "\"message\":\"No content found \""
					+ "\"developerMessage\":\"" + err.getMessage() + "\"" + "}";
			return Response.status(401).entity(newResponse).build();

		}
		return Response.ok(newResponse).build();
	}
	
	// /rest/fault/imsicausecodes
	@GET
	@PermitAll
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/imsicausecodes")
	public Response getImsiCauseCodes(@FormParam("searchimsi") Long searchimsi,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {

		String newResponse = null;
		searchimsi = 191911000516761L;
		try {
			newResponse = toJSONString(service.getCauseCodePerIMSI(searchimsi));
		} catch (Exception err) {
			newResponse = "{\"status\":\"401\","
					+ "\"message\":\"No content found \""
					+ "\"developerMessage\":\"" + err.getMessage() + "\"" + "}";
			return Response.status(401).entity(newResponse).build();

		}
		return Response.ok(newResponse).build();
	}

	// /rest/fault/imsifailuresovertime
	@GET
	@PermitAll
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/imsifailuresovertime")
	public Response getAllIMSIFailuresOverTime(@FormParam("startDate") Timestamp startDate,
			@FormParam("endDate") Timestamp endDate,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {

		String newResponse = null;
		startDate = Timestamp.valueOf("2013-02-19 00:00:00");
		endDate = Timestamp.valueOf("2013-02-22 00:00:00");

		try {
			newResponse = toJSONString(service.getIMSIFailureOverTime(startDate,endDate));
		} catch (Exception err) {
			newResponse = "{\"status\":\"401\","
					+ "\"message\":\"No content found \""
					+ "\"developerMessage\":\"" + err.getMessage() + "\"" + "}";
			return Response.status(401).entity(newResponse).build();

		}
		return Response.ok(newResponse).build();

	}
	
	
	// /rest/fault/totalfaults
	@GET
	@Path("/totalfaults")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTotalFaultsAndDurationPerIMSI(
			@FormParam("startdate") Timestamp startdate,
			@FormParam("enddate") Timestamp enddate)
	{
		startdate = Timestamp.valueOf("2013-02-19 00:00:00");
		enddate = Timestamp.valueOf("2013-02-22 00:00:00");
		
		String newResponse = null;

		try {
			newResponse = toJSONString(service.getTotalFaultsAndDurationPerIMSI(startdate, enddate));
		} catch (Exception err) {
			newResponse = "{\"status\":\"401\","
					+ "\"message\":\"No content found \""
					+ "\"developerMessage\":\"" + err.getMessage() + "\"" + "}";
			return Response.status(401).entity(newResponse).build();

		}
		return Response.ok(newResponse).build();

	}
	
	

	public String toJSONString(Object object) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setDateFormat("yyyy-mm-dd'T'HH:mm:ss.SSS'Z'");

		Gson gson = gsonBuilder.create();
		return gson.toJson(object);
	}

}
