package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.OSType;

@Local
public interface OSTypeDAO {

	Collection<OSType> getOSType();
	OSType getByOSType(String os);
<<<<<<< HEAD
	void createOSType(String osType);
=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}
