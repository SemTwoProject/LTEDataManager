package com.dao;

import javax.ejb.Local;

import com.entities.IMSI;

import java.util.Collection;
@Local
public interface IMSIDAO {

	Collection<IMSI> getIMSI();
	IMSI getByIMSI(Long imsi);
	public void createIMSI(Long imsi);
}
