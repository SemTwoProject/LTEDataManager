package com.interfaces;

import java.util.Collection;

import com.entity.Fault;
import com.entity.UE;

public interface UEServiceLocal {
	Collection<UE> getAllUE();
	Collection<Fault> getEventCausePerModel(String model);
}