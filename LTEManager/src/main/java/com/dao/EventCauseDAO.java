package com.dao;

import javax.ejb.Local;

import com.entity.EventCause;
import com.entity.Fault;

import java.util.Collection;
import java.util.List;
@Local
public interface EventCauseDAO {

	Collection<EventCause> getEventCause();
	EventCause getByEventCause(Integer event);
	List<Object> getEventCauseByFault(Fault fault);
	public void createEventCauses();
}