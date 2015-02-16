package service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import dao.MNCDAO;
import entities.MNC;

@Stateless
@Local
public class MNCServiceEJB implements MNCServiceLocal {

	@EJB
	private MNCDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<MNC> getAllMNC() {
		return dao.getMNC();
	}

}
