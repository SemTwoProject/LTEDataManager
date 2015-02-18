package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entities.InputMode;
import com.entities.OSType;
import com.entities.UE;
import com.entities.UEType;

@Local
public interface UEDAO {

	Collection<UE> getUE();
	UE getByTac(Integer tac);
	void createUE(Integer tac, String marketingName, String manufacturer,
			String accessCapability, String model, String vendorName,
			OSType os, InputMode inputMode, UEType ueType);
}
