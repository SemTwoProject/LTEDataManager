package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.EventId;

@Local
public interface EventIdDAO {

	Collection<EventId> getEventId();
	EventId getByEventId(Integer eventId);
	public void createEventId(Integer eventId);

}
