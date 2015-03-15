package com.dao;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;

import com.entity.EventCause;
import com.entity.Fault;

@Local
public interface EventCauseDAO {

	Collection<EventCause> getEventCause(Integer eventid);

	Collection<EventCause> getByEventCause(Integer event);

	Collection<EventCause> getEventCauseByFault(Fault fault);
}