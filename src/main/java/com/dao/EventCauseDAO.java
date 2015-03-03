package com.dao;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;

import com.entity.EventCause;
import com.entity.Fault;

@Local
public interface EventCauseDAO {

	EventCause getEventCause(Integer eventid);

	EventCause getByEventCause(Integer event);

	List<Object> getEventCauseByFault(Fault fault);
}