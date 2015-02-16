package service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import dao.FailureDAO;
import entities.Failure;

@Stateless
@Local
public class FailureServiceEJB implements FailureServiceLocal {

	@EJB
	private FailureDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<Failure> getAllFailure() {
		return dao.getFailure();
	}

}
