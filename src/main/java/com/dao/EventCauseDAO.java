<<<<<<< HEAD
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
=======
package com.dao;

import java.util.List;

import javax.ejb.Local;

import com.entity.EventCause;
import com.entity.Fault;

@Local
public interface EventCauseDAO {

	EventCause getEventCause(Integer eventid);

	EventCause getByEventCause(Integer event);

	List<Object> getEventCauseByFault(Fault fault);
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
}