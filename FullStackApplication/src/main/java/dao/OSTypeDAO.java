package dao;

import java.util.Collection;

import javax.ejb.Local;

import entities.OSType;

@Local
public interface OSTypeDAO {

	Collection<OSType> getOSType();
	OSType getByOSType(String os);
	void createOSType(String osType);
}
