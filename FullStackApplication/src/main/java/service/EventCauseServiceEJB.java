package service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import dao.EventCauseDAO;
import entities.EventCause;

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