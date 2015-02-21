package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.DurationDAO;
import com.entity.Duration;

@Stateless
@Local
public class DurationServiceEJB implements DurationServiceLocal {

	@EJB
	private DurationDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<Duration> getAllDuration() {
		return dao.getDuration();
	}
}
