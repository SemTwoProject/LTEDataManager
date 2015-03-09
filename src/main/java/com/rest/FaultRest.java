package com.rest;

import java.io.IOException;
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

	@POST
	@Path("/totalfaults")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Object> getTotalFaultsAndDurationPerIMSI(
			@FormParam("startdate") Timestamp startdate,
			@FormParam("enddate") Timestamp enddate)
			{
		return service.getTotalFaultsAndDurationPerIMSI(startdate, enddate);
			}

	// /rest/fault/imsicount
	@GET
	@PermitAll
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/imsicount")
	public void getImsiCount(@FormParam("startDate") Timestamp startDate,
			@FormParam("endDate") Timestamp endDate,
			@FormParam("searchimsi") Long searchimsi,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws IOException {

		String newResponse = null;
		searchimsi = 191911000516761L;
		startDate = Timestamp.valueOf("2013-02-19 00:00:00");
		endDate = Timestamp.valueOf("2013-02-22 00:00:00");

		System.out.println("WE ARE HERE" + startDate);
		System.out.println("WE ARE HERE" + endDate);
		System.out.println("WE ARE HERE" + searchimsi);

		//response = toJSONString(faultService.getImsiCount(date,imsi));

		newResponse = toJSONString(service.getImsiCount(startDate,endDate,searchimsi));
	}

	public String toJSONString(Object object) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setDateFormat("yyyy-mm-dd'T'HH:mm:ss.SSS'Z'");

		Gson gson = gsonBuilder.create();
		return gson.toJson(object);
	}

}