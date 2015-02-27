package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
<<<<<<< HEAD
import javax.ejb.Stateless;
=======
import javax.ejb.Stateful;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.EventIdDAO;
import com.entity.EventId;
<<<<<<< HEAD
import com.serviceInterfaces.EventIdServiceLocal;

@Stateless
=======

@Stateful
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public class EventIdServiceEJB implements EventIdServiceLocal {

	@EJB
	private EventIdDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<EventId> getAllEventId() {
		return dao.getEventId();
	}
<<<<<<< HEAD

=======
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public EventId getByEventId(Integer eventId){
		return dao.getByEventId(eventId);
	}
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}