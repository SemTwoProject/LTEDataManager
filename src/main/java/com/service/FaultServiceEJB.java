<<<<<<< HEAD
package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;

import com.dao.FaultDAO;
import com.entity.Fault;

@Stateful
@Local
public class FaultServiceEJB implements FaultServiceLocal {

	@EJB
	private FaultDAO dao;

	public Collection<Fault> getAllFault() {
		return dao.getFault();
	}

	public Collection<Object> getFaultByIMSI(Long imsi) {
		return dao.getFaultByIMSI(imsi);
	}

	@Override
	public Collection<Object> getTotalFaultsAndDurationPerIMSI() {
		return dao.getTotalFaultsAndDurationPerIMSI();
	}
}
=======
package com.service;

import java.sql.Timestamp;
import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;

import com.dao.FaultDAO;
import com.entity.Fault;

@Stateful
@Local
public class FaultServiceEJB implements FaultServiceLocal {

	@EJB
	private FaultDAO dao;

	public Collection<Fault> getAllFault() {
		return dao.getFault();
	}

	public Collection<Object> getFaultByIMSI(Long imsi) {
		return dao.getFaultByIMSI(imsi);
	}

	@Override
	public Collection<Object> getTotalFaultsAndDurationPerIMSI(
			Timestamp startdate, Timestamp enddate) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Collection<Object> getTotalFaultsAndDurationPerIMSI() {
		return dao.getTotalFaultsAndDurationPerIMSI();
	public Collection<Object> getTotalFaultsAndDurationPerIMSI(Timestamp start, Timestamp end)
	{
		return dao.getTotalFaultsAndDurationPerIMSI(start, end);

	}*/
}
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
