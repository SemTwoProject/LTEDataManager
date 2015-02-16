package dao;

import javax.ejb.Local;

import java.util.Collection;

import entities.EventCause;
import entities.EventId;
@Local
public interface EventCauseDAO {

	Collection<EventCause> getEventCause();
	EventCause getByEventCause(Integer event);
	public void createEventCause(Integer event, String description, EventId eventId);
}
