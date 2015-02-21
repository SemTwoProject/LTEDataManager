package com.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.EventCauseDAO;
import com.dao.FailureDAO;
import com.dao.FaultDAO;
import com.entity.Fault;

@Stateless
@Local
public class EventFailureIMSIServiceEJB implements EventFailureIMSIServiceLocal {

	@EJB
	private EventCauseDAO eventCauseDao;
	@EJB
	private FaultDAO faultDao;
	@EJB
	private FailureDAO failureDao;
	
	private Fault fault;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<Object> getAllEventsAndFailure(Long imsi) {
		List<Object> rs = new ArrayList<Object>();
		fault = faultDao.getFaultByIMSI(imsi);
		rs.addAll(eventCauseDao.getEventCauseByFault(fault));
		rs.addAll(failureDao.getFailureByFault(fault));
		return rs;
	}

}