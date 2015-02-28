package com.dao;

<<<<<<< HEAD
import java.util.Collection;

=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
import javax.ejb.Local;

import com.entity.EventCause;
import com.entity.EventId;
<<<<<<< HEAD
=======
import com.entity.Fault;

import java.util.Collection;
import java.util.List;

>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public interface EventCauseDAO {

	Collection<EventCause> getEventCause();
<<<<<<< HEAD
	EventCause getByEventCause(Integer event);
	public void createEventCause(Integer event, String description, EventId eventId);
}
=======

	EventCause getByEventCause(Integer event);

	List<Object> getEventCauseByFault(Fault fault);

	EventId getByEventId(Integer eventId);
}
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
