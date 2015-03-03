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
