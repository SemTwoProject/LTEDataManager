package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;

import com.dao.UEDAO;
import com.entity.Fault;
import com.interfaces.UEServiceLocal;

@Stateful
@Local
public class UEServiceEJB implements UEServiceLocal {

	@EJB
	private UEDAO dao;

	public Collection<Fault> getEventCausePerModel(String model) {
		return dao.getEventCausePerModel(model);
	}
}
