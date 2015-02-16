package dao;

import java.util.Collection;

import javax.ejb.Local;

import entities.InputMode;
import entities.OSType;
import entities.UE;
import entities.UEType;

@Local
public interface UEDAO {

	Collection<UE> getUE();
	UE getByTac(Integer tac);
	void createUE(Integer tac, String marketingName, String manufacturer,
			String accessCapability, String model, String vendorName,
			OSType os, InputMode inputMode, UEType ueType);
}
