package dao;

import javax.ejb.Local;

import entities.NEVersion;

import java.util.Collection;
@Local
public interface NEVersionDAO {

	Collection<NEVersion> getNEVersion();
	NEVersion getByNE(Integer ne);
}
