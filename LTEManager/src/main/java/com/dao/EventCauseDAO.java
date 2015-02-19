package com.dao;

import javax.ejb.Local;

import com.entities.EventCause;
import com.entities.EventId;

import java.util.Collection;
@Local
public interface EventCauseDAO {

	Collection<EventCause> getEventCause();
	EventCause getByEventCause(Integer event);
	public void createEventCause(Integer event, String description, EventId eventId);
}
