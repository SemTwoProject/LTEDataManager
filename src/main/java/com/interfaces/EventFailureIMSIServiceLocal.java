package com.interfaces;

import java.util.Collection;


public interface EventFailureIMSIServiceLocal {
	Collection<Object> getAllEventsAndFailure(Long imsi);
}