package service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import dao.FaultDAO;
import entities.Fault;

@Stateless
@Local
public class FaultServiceEJB implements FaultServiceLocal {

	@EJB
	private FaultDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<Fault> getAllFault() {
		return dao.getFault();
	}
}
