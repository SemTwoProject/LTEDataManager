package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
<<<<<<< HEAD
import javax.ejb.Stateless;
=======
import javax.ejb.Stateful;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.FaultDAO;
import com.entity.Fault;
<<<<<<< HEAD
import com.serviceInterfaces.FaultServiceLocal;

@Stateless
=======

@Stateful
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public class FaultServiceEJB implements FaultServiceLocal {

	@EJB
	private FaultDAO dao;

	public Collection<Fault> getAllFault() {
		return dao.getFault();
	}

<<<<<<< HEAD
	public Collection<Object> getFaultByIMSI(Long imsi) {
		return dao.getFaultByIMSI(imsi);
	}
=======
<<<<<<< HEAD
=======
	@Override
	public Collection<Object> getTotalFaultsAndDurationPerIMSI()
	{
		return dao.getTotalFaultsAndDurationPerIMSI();
	}
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
>>>>>>> 324425364305526399e910bc0c61b9a257e84f9f
}
