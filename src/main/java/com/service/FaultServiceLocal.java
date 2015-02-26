package com.service;

import java.util.Collection;

import com.entity.Fault;
import com.entity.IMSI;

public interface FaultServiceLocal {
	Collection<Fault> getAllFault();
	Collection<Object> getFaultByIMSI(Long imsi);
}