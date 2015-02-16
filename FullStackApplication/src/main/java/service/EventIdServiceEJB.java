package service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import dao.EventIdDAO;
import entities.EventId;

@Stateless
@Local
public class EventIdServiceEJB implements EventIdServiceLocal {

	@EJB
	private EventIdDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<EventId> getAllEventId() {
		return dao.getEventId();
	}

}