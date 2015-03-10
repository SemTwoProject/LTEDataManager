package com.service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;

import com.dao.FaultDAO;
import com.entity.EventCause;
import com.entity.Fault;

@Stateful
@Local
public class FaultServiceEJB implements FaultServiceLocal {

	@EJB
	private FaultDAO dao;

	public Collection<EventCause> getFaultByIMSI(Long imsi) {
		return dao.getFaultByIMSI(imsi);
	}
	
	@Override
	public Collection<Fault> getTotalFaultsAndDurationPerIMSI(
			Timestamp start, Timestamp end) {
		return dao.getTotalFaultsAndDurationPerIMSI(start, end);
	}

	
}
