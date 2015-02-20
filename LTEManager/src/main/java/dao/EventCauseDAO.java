package dao;

import javax.ejb.Local;

import entities.EventCause;

import java.util.Collection;
@Local
public interface EventCauseDAO {

	Collection<EventCause> getEventCause();
	EventCause getByEventCause(Integer event);
}
