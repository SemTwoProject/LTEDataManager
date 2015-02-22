package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.OSTypeDAO;
import com.entity.OSType;

@Stateful
@Local
public class OSTypeServiceEJB implements OSTypeServiceLocal {

	@EJB
	private OSTypeDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<OSType> getAllOSType() {
		return dao.getOSType();
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createOSTypes(){
		dao.createOSTypes();
	}
}
