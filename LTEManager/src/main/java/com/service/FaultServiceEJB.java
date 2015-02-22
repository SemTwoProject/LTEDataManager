package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.FaultDAO;
import com.entity.Fault;

@Stateful
@Local
public class FaultServiceEJB implements FaultServiceLocal {

	@EJB
	private FaultDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<Fault> getAllFault() {
		return dao.getFault();
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createFaults(){
		dao.createFaults();
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createFaultsTwo(){
		dao.createFaultsTwo();
	}
}
