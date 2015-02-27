package com.service;

import java.util.Collection;


public interface EventFailureIMSIServiceLocal {
	Collection<Object> getAllEventsAndFailure(Long imsi);
}