package com.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.dao.EventCauseDAO;
import com.dao.FailureDAO;
import com.dao.FaultDAO;
import com.entity.Fault;

@Stateful
@Local
public class EventFailureIMSIServiceEJB implements EventFailureIMSIServiceLocal {

	@Inject
	private EventCauseDAO eventCauseDao;
	@Inject
	private FaultDAO faultDao;
	@Inject
	private FailureDAO failureDao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<Object> getAllEventsAndFailure(Long imsi) {
		List<Object> rs = new ArrayList<Object>();

		Collection<Fault> faults = faultDao.getFaultByIMSI(imsi);
		for (Fault fault : faults) {
			rs.add(eventCauseDao.getEventCauseByFault(fault));

			rs.add(failureDao.getFailureByFault(fault));
		}
		return rs;
	}

}