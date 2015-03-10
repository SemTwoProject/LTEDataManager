package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.UEDAO;
import com.entity.Fault;
import com.entity.UE;
import com.interfaces.UEServiceLocal;

@Stateful
@Local
public class UEServiceEJB implements UEServiceLocal {

	@EJB
	private UEDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<UE> getAllUE() {
		return dao.getUE();
	}

	public Collection<Fault> getEventCausePerModel(String model) {
		return dao.getEventCausePerModel(model);
	}
}
