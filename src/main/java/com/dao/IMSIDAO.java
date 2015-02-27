package com.dao;

<<<<<<< HEAD
import java.util.Collection;

import javax.ejb.Local;

import com.entity.IMSI;
=======
import javax.ejb.Local;

import com.entity.IMSI;

import java.util.Collection;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public interface IMSIDAO {

	Collection<IMSI> getIMSI();
	IMSI getByIMSI(Long imsi);
<<<<<<< HEAD
	public void createIMSI(Long imsi);
=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}
