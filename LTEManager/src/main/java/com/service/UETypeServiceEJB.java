package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.UETypeDAO;
import com.entity.UEType;

@Stateless
@Local
public class UETypeServiceEJB implements UETypeServiceLocal {

	@EJB
	private UETypeDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<UEType> getAllUEType() {
		return dao.getUEType();
	}

}
