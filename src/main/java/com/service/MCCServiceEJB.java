<<<<<<< HEAD
package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.MCCDAO;
import com.entity.MccMnc;

@Stateful
@Local
public class MCCServiceEJB implements MCCServiceLocal {

	@EJB
	private MCCDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<MccMnc> getAllMCC() {
		return dao.getMCC();
	}
}
=======
package com.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.MCCDAO;
import com.entity.MccMnc;

@Stateful
@Local
public class MCCServiceEJB implements MCCServiceLocal {

	@EJB
	private MCCDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<MccMnc> getAllMCC() {
		return dao.getMCC();
	}
}
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
