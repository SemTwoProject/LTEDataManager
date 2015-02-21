package com.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

	private EventCauseDAO eventCauseDao;
	private FaultDAO faultDao;
	private FailureDAO failureDao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<Object> getAllEventsAndFailure(Long imsi) {
		List<Object> rs = new ArrayList<Object>();

		Collection<Fault> faults = faultDao.getFaultByIMSI(imsi);
		for (Fault fault : faults) {
			rs.addAll(eventCauseDao.getEventCauseByFault(fault));

			rs.addAll(failureDao.getFailureByFault(fault));
		}
		return rs;
	}

}