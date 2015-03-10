package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.FailureDAO;
import com.entity.Failure;
import com.interfaces.FailureServiceLocal;

@Stateful
@Local
public class FailureServiceEJB implements FailureServiceLocal{

	@EJB
	private FailureDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<Failure> getAllFailure() {
		return dao.getFailure();
	}
}
