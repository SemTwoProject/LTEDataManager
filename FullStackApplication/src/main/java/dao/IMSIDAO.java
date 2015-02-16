package dao;

import javax.ejb.Local;

import java.util.Collection;

import entities.IMSI;
@Local
public interface IMSIDAO {

	Collection<IMSI> getIMSI();
	IMSI getByIMSI(Long imsi);
	public void createIMSI(Long imsi);
}
