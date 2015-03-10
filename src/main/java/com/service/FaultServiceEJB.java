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
	
	public Collection<Fault> getEventCausePerIMSI(Long imsi) {
		return dao.getEventCausePerIMSI(imsi);
	}
	
	public Collection<Fault> getTotalFaultsAndDurationPerIMSI(Timestamp start, Timestamp end) {
			return dao.getTotalFaultsAndDurationPerIMSI(start, end);
	}
	
	public Collection<Fault> getIMSICount(Timestamp start, Timestamp end,Long imsi) {
		return dao.getIMSICount(start, end, imsi);
	}

	public Collection<Fault> getCauseCodePerIMSI(Long imsi) {
		return dao.getCauseCodePerIMSI(imsi);
	}

	public Collection<Fault> getIMSIFailureOverTime(Timestamp start,Timestamp end) {
		return dao.getIMSIFailureOverTime(start, end);
	}

	public Collection<Fault> getAllFault() {
		return null;
	}

	@Override
	public Collection<Fault> getImsiPerFailure(int failure) {
		return dao.getImsiPerFailure(failure);
	}
}
