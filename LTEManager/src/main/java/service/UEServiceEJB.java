package service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import dao.UEDAO;
import entities.UE;

@Stateless
@Local
public class UEServiceEJB implements UEServiceLocal {

	@EJB
	private UEDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<UE> getAllUE() {
		return dao.getUE();
	}

}
