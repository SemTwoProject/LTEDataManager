package service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import dao.IMSIDAO;
import entities.IMSI;

@Stateless
@Local
public class IMSIServiceEJB implements IMSIServiceLocal {

	@EJB
	private IMSIDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<IMSI> getAllIMSI() {
		return dao.getIMSI();
	}

}
