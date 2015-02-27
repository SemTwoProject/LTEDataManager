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

import com.dao.DurationDAO;
import com.entity.Duration;
<<<<<<< HEAD
import com.serviceInterfaces.DurationServiceLocal;

@Stateless
=======

@Stateful
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public class DurationServiceEJB implements DurationServiceLocal {

	@EJB
	private DurationDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<Duration> getAllDuration() {
		return dao.getDuration();
	}
<<<<<<< HEAD

=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}
