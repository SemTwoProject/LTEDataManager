package com.dao;

import javax.ejb.Local;

import com.entities.NEVersion;

import java.util.Collection;
@Local
public interface NEVersionDAO {

	Collection<NEVersion> getNEVersion();
	NEVersion getByNE(Integer ne);
	void createNEVersion(Integer neId);
}
