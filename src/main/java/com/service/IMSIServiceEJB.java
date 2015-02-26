package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.IMSIDAO;
import com.entity.IMSI;

@Stateful
@Local
public class IMSIServiceEJB implements IMSIServiceLocal {

	@EJB
	private IMSIDAO dao;

	public Collection<IMSI> getAllIMSI() {
		return dao.getIMSI();
	}

	public IMSI getByIMSI(Long imsi) {
		return dao.getByIMSI(imsi);
	}
}
