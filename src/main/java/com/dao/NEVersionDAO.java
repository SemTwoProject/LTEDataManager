package com.dao;

<<<<<<< HEAD
import java.util.Collection;

import javax.ejb.Local;

import com.entity.NEVersion;
=======
import javax.ejb.Local;

import com.entity.NEVersion;

import java.util.Collection;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public interface NEVersionDAO {

	Collection<NEVersion> getNEVersion();
<<<<<<< HEAD
	NEVersion getByNE(Integer ne);
	void createNEVersion(Integer neId);
=======
	NEVersion getByNE(String ne);
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}
