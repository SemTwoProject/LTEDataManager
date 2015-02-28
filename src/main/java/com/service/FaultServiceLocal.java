package com.service;

import java.util.Collection;

import com.entity.Fault;
import com.entity.IMSI;

public interface FaultServiceLocal {
	Collection<Fault> getAllFault();
<<<<<<< HEAD
	Collection<Object> getFaultByIMSI(Long imsi);
=======
	Collection<Object> getTotalFaultsAndDurationPerIMSI();
>>>>>>> 324425364305526399e910bc0c61b9a257e84f9f
}