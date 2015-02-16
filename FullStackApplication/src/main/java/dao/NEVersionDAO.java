package dao;

import javax.ejb.Local;

import java.util.Collection;

import entities.NEVersion;
@Local
public interface NEVersionDAO {

	Collection<NEVersion> getNEVersion();
	NEVersion getByNE(Integer ne);
	void createNEVersion(Integer neId);
}
