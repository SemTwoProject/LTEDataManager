package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.NEVersionDAO;
import com.entity.NEVersion;

@Stateful
@Local
public class NEVersionServiceEJB implements NEVersionServiceLocal {

	@EJB
	private NEVersionDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<NEVersion> getAllNEVersion() {
		return dao.getNEVersion();
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createNEVersions(){
		dao.createNEVersions();
	}
}
