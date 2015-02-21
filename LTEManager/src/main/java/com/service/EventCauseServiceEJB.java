package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.EventCauseDAO;
import com.entity.EventCause;

@Stateless
@Local
public class EventCauseServiceEJB implements EventCauseServiceLocal {

	@EJB
	private EventCauseDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<EventCause> getAllEventCause() {
		return dao.getEventCause();
	}
}