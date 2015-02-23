package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.MNCDAO;
import com.entity.MNC;

@Stateful
@Local
public class MNCServiceEJB implements MNCServiceLocal {

	@EJB
	private MNCDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<MNC> getAllMNC() {
		return dao.getMNC();
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createMNCs(){
		dao.createMNCs();
	}
}