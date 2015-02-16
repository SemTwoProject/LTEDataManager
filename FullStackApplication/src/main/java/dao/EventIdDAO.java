package dao;

import java.util.Collection;

import javax.ejb.Local;

import entities.EventId;

@Local
public interface EventIdDAO {

	Collection<EventId> getEventId();
	EventId getByEventId(Integer eventId);
	public void createEventId(Integer eventId);

}
