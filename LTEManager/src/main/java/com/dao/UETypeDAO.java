package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entities.UEType;

@Local
public interface UETypeDAO {

	Collection<UEType> getUEType();
	UEType getByUEType(String ue);
	void createUEType(String ueType);
}
