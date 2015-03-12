package com.rest;

import java.sql.Timestamp;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.interfaces.FaultServiceLocal;

@Path("/fault")
public class FaultRest {
	@EJB
	private FaultServiceLocal service;

	// rest/fault/faultsbyimsi - Story 4
	@POST
	@Path("/faultsbyimsi")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFaultByIMSI(@FormParam("imsi") Long imsi) {
		String newResponse = null;
		try {
			newResponse = toJSONString(service.getEventCausePerIMSI(imsi));
		} catch (Exception err) {
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
			@FormParam("imsi") Long imsi) {

		String newResponse = null;
		/*
		 * startdate = Timestamp.valueOf("2013-02-19 00:00:00"); enddate =
		 * Timestamp.valueOf("2013-02-22 00:00:00"); imsi = 191911000516761L;
		 */

		try {
			newResponse = toJSONString(service.getIMSICount(startdate, enddate,
					imsi));
		} catch (Exception err) {
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
	public Response getCauseCodesPerIMSI(@FormParam("imsi") Long imsi) {

		String newResponse = null;

		try {
			newResponse = toJSONString(service.getCauseCodePerIMSI(imsi));
		} catch (Exception err) {
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
			@FormParam("enddate") Timestamp enddate) {

		String newResponse = null;

		try {
			newResponse = toJSONString(service.getIMSIFailureOverTime(
					startdate, enddate));
		} catch (Exception err) {
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
			@FormParam("enddate") Timestamp enddate) {
		String newResponse = null;

		try {
			newResponse = toJSONString(service
					.getTotalFaultsAndDurationPerIMSI(startdate, enddate));
		} catch (Exception err) {
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
			@FormParam("enddate") Timestamp enddate) {
		String newResponse = null;

		try {
			newResponse = toJSONString(service.getTopTenIMSIOverTime(startdate,
					enddate));
		} catch (Exception err) {
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
			@FormParam("enddate") Timestamp endDate) {
		String newResponse = null;

		try {
			newResponse = toJSONString(service.getAmountOfCallFailuresPerModel(model, startDate, endDate));
		} catch (Exception err) {
			newResponse = "{\"status\":\"401\","
					+ "\"message\":\"No content found \""
					+ "\"developerMessage\":\"" + err.getMessage() + "\"" + "}";
			return Response.status(401).entity(newResponse).build();

		}
		return Response.ok(newResponse).build();

	}

	@POST
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/imsifailures")
	public Response getImsiPerFailure(@FormParam("failure") int failure) {
		String newResponse = null;
		failure = 0;

		try {
			newResponse = toJSONString(service.getImsiPerFailure(failure));
		} catch (Exception err) {
			newResponse = "{\"status\":\"401\","
					+ "\"message\":\"No content found \""
					+ "\"developerMessage\":\"" + err.getMessage() + "\"" + "}";
			return Response.status(401).entity(newResponse).build();

		}
		return Response.ok(newResponse).build();

	}
	
	@POST
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/imsifailures")
	public Response getTopTenMarketOperatorCell(
			@FormParam("startdate") Timestamp startDate,
			@FormParam("enddate") Timestamp endDate) {
		String newResponse = null;

		try {
			newResponse = toJSONString(service.getTopTenMarketOperatorCell(startDate, endDate));
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
