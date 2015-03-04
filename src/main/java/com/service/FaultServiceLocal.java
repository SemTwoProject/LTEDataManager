<<<<<<< HEAD
package com.service;

import java.util.Collection;

import com.entity.Fault;

public interface FaultServiceLocal {
	Collection<Fault> getAllFault();
	Collection<Object> getFaultByIMSI(Long imsi);
	Collection<Object> getTotalFaultsAndDurationPerIMSI();
=======
package com.service;

import java.sql.Timestamp;
import java.util.Collection;

import com.entity.Fault;

public interface FaultServiceLocal {
	Collection<Fault> getAllFault();
	Collection<Object> getFaultByIMSI(Long imsi);
	Collection<Object> getTotalFaultsAndDurationPerIMSI(Timestamp startdate, Timestamp enddate);
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
}