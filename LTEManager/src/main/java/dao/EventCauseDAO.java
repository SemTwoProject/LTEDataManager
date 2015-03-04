package dao;

import javax.ejb.Local;

import entities.EventCause;
import entities.Fault;

import java.util.Collection;
import java.util.List;
@Local
public interface EventCauseDAO {

	Collection<EventCause> getEventCause();
	EventCause getByEventCause(Integer event);
	List<Object> getEventCauseByFault(Fault fault);
}