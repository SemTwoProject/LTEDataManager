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

import com.dao.EventCauseDAO;
import com.entity.EventCause;
<<<<<<< HEAD
import com.serviceInterfaces.EventCauseServiceLocal;

@Stateless
=======

@Stateful
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public class EventCauseServiceEJB implements EventCauseServiceLocal {

	@EJB
	private EventCauseDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<EventCause> getAllEventCause() {
		return dao.getEventCause();
	}
<<<<<<< HEAD

=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}