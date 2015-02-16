package dao;

import java.util.Collection;

import javax.ejb.Local;

import entities.UEType;

@Local
public interface UETypeDAO {

	Collection<UEType> getUEType();
	UEType getByUEType(String ue);
	void createUEType(String ueType);
}
