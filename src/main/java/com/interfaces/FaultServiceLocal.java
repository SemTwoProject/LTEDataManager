<<<<<<< HEAD
package com.interfaces;

import java.util.Collection;

import com.entity.Fault;

public interface FaultServiceLocal {
	Collection<Fault> getAllFault();
	Collection<Object> getTotalFaultsAndDurationPerIMSI();
=======
package com.interfaces;

import java.sql.Timestamp;
import java.util.Collection;

import com.entity.Fault;

public interface FaultServiceLocal {
	Collection<Fault> getAllFault();
	Collection<Object> getTotalFaultsAndDurationPerIMSI(Timestamp start, Timestamp end);
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
}