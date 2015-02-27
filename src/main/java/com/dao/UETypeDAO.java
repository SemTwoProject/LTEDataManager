package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.UEType;

@Local
public interface UETypeDAO {

	Collection<UEType> getUEType();
	UEType getByUEType(String ue);
<<<<<<< HEAD
	void createUEType(String ueType);
=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}
