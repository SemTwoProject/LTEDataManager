package service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import dao.MCCDAO;
import entities.MCC;

@Stateless
@Local
public class MCCServiceEJB implements MCCServiceLocal {

	@EJB
	private MCCDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<MCC> getAllMCC() {
		return dao.getMCC();
	}
}
