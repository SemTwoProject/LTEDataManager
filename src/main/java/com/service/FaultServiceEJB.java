package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.FaultDAO;
import com.entity.Fault;
import com.serviceInterfaces.FaultServiceLocal;

@Stateless
@Local
public class FaultServiceEJB implements FaultServiceLocal {

	@EJB
	private FaultDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<Fault> getAllFault() {
		return dao.getFault();
	}

}
