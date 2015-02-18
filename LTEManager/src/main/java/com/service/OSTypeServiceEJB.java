package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.OSTypeDAO;
import com.entities.OSType;

@Stateless
@Local
public class OSTypeServiceEJB implements OSTypeServiceLocal {

	@EJB
	private OSTypeDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<OSType> getAllOSType() {
		return dao.getOSType();
	}

}
