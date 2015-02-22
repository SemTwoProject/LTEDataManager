package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.EventIdDAO;
import com.entity.EventId;

@Stateful
@Local
public class EventIdServiceEJB implements EventIdServiceLocal {

	@EJB
	private EventIdDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<EventId> getAllEventId() {
		return dao.getEventId();
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createEventIds(){
		dao.createEventIds();
	}
}