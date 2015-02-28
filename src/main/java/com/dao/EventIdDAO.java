package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.EventId;

@Local
public interface EventIdDAO {

	Collection<EventId> getEventId();
	EventId getByEventId(Integer eventId);
<<<<<<< HEAD
	public void createEventId(Integer eventId);

=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}
