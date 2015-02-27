package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
<<<<<<< HEAD
import javax.ejb.Stateless;
=======
import javax.ejb.Stateful;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.IMSIDAO;
import com.entity.IMSI;
<<<<<<< HEAD
import com.serviceInterfaces.IMSIServiceLocal;

@Stateless
=======

@Stateful
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public class IMSIServiceEJB implements IMSIServiceLocal {

	@EJB
	private IMSIDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<IMSI> getAllIMSI() {
		return dao.getIMSI();
	}
<<<<<<< HEAD

=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}
