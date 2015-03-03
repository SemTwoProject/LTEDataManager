package service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import dao.NEVersionDAO;
import entities.NEVersion;

@Stateless
@Local
public class NEVersionServiceEJB implements NEVersionServiceLocal {

	@EJB
	private NEVersionDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<NEVersion> getAllNEVersion() {
		return dao.getNEVersion();
	}
}
