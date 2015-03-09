package com.service;

import java.sql.Timestamp;
import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;

import com.dao.FaultDAO;
import com.entity.EventCause;
import com.entity.Fault;
import com.interfaces.FaultServiceLocal;

@Stateful
@Local
public class FaultServiceEJB implements FaultServiceLocal {

	@EJB
	private FaultDAO dao;

	public Collection<EventCause> getFaultByIMSI(Long imsi) {
		return dao.getFaultByIMSI(imsi);
	}

	public Collection<Object> getTotalFaultsAndDurationPerIMSI(
			Timestamp start, Timestamp end) {
		return dao.getTotalFaultsAndDurationPerIMSI(start, end);
	}
	
	public Long getIMSICount(Timestamp start, Timestamp end,Long imsi) {
		return dao.getIMSICount(start, end, imsi);
	}

	public Collection<Fault> getCauseCodePerIMSI(Long imsi) {
		return dao.getCauseCodePerIMSI(imsi);
	}

	@Override
	public Collection<Fault> getIMSIFailureOverTime(Timestamp start,Timestamp end) {
		// TODO Auto-generated method stub
		return dao.getIMSIFailureOverTime(start, end);
	}
}
