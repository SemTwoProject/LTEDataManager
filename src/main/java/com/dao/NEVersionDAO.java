package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.NEVersion;
@Local
public interface NEVersionDAO {

	Collection<NEVersion> getNEVersion();
	NEVersion getByNE(Integer ne);
	void createNEVersion(Integer neId);
}
