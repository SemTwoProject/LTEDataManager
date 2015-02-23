package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.OSType;

@Local
public interface OSTypeDAO {

	Collection<OSType> getOSType();
	OSType getByOSType(String os);
}
