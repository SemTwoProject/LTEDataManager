package com.service;

import java.sql.Timestamp;
import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;

import com.dao.FaultDAO;
import com.entity.EventCause;
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
	
	public Long getImsiCount(Timestamp start, Timestamp end,
			Long imsi) {
		return dao.getImsiCount(start, end, imsi);
	}
}
