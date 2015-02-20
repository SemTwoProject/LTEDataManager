package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.IMSI;
@Local
public interface IMSIDAO {

	Collection<IMSI> getIMSI();
	IMSI getByIMSI(Long imsi);
	public void createIMSI(Long imsi);
}
