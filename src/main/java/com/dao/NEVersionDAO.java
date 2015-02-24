package com.dao;

import javax.ejb.Local;

import com.entity.NEVersion;

import java.util.Collection;
@Local
public interface NEVersionDAO {

	Collection<NEVersion> getNEVersion();
	NEVersion getByNE(String ne);
}
