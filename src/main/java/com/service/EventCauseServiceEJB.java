<<<<<<< HEAD
package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.EventCauseDAO;
import com.entity.EventCause;

@Stateful
@Local
public class EventCauseServiceEJB implements EventCauseServiceLocal {

	@EJB
	private EventCauseDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public EventCause getAllEventCause(Integer eventid) {
		return dao.getEventCause(eventid);
	}
=======
package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.EventCauseDAO;
import com.entity.EventCause;

@Stateful
@Local
public class EventCauseServiceEJB implements EventCauseServiceLocal {

	@EJB
	private EventCauseDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public EventCause getAllEventCause(Integer eventid) {
		return dao.getEventCause(eventid);
	}
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
}