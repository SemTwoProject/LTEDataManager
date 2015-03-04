package dao;

import javax.ejb.Local;

import entities.IMSI;

import java.util.Collection;
@Local
public interface IMSIDAO {

	Collection<IMSI> getIMSI();
	IMSI getByIMSI(Long imsi);
}
