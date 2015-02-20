package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.EventCause;
import com.entity.EventId;
@Local
public interface EventCauseDAO {

	Collection<EventCause> getEventCause();
	EventCause getByEventCause(Integer event);
	public void createEventCause(Integer event, String description, EventId eventId);
}
