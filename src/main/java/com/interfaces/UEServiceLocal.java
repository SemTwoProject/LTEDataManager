package com.interfaces;

import java.util.Collection;

import com.entity.Fault;

public interface UEServiceLocal {
	Collection<Fault> getEventCausePerModel(String model);
}