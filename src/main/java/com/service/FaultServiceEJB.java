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
<<<<<<< HEAD
	public Collection<Object> getTotalFaultsAndDurationPerIMSI() {
		return dao.getTotalFaultsAndDurationPerIMSI();
=======
	public Collection<Object> getTotalFaultsAndDurationPerIMSI(Timestamp start, Timestamp end)
	{
		return dao.getTotalFaultsAndDurationPerIMSI(start, end);
>>>>>>> 6ab11dcb92ea0679af53a5d6dc0e734a03282b21
	}
}
