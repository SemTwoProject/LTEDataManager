package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.MCCDAO;
import com.entity.MCC;

@Stateful
@Local
public class MCCServiceEJB implements MCCServiceLocal {

	@EJB
	private MCCDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<MCC> getAllMCC() {
		return dao.getMCC();
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createMCCs(){
		dao.createMCCs();
	}
}
