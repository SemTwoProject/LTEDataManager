package com.service;

import java.util.Collection;

import com.entity.EventCause;

public interface EventCauseServiceLocal {
	Collection<EventCause> getAllEventCause();
	public void createEventCauses();
}