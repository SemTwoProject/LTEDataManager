package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.InputMode;
import com.entity.OSType;
import com.entity.UE;
import com.entity.UEType;

@Local
public interface UEDAO {

	Collection<UE> getUE();
	UE getByTac(Integer tac);
	void createUE(Integer tac, String marketingName, String manufacturer,
			String accessCapability, String model, String vendorName,
			OSType os, InputMode inputMode, UEType ueType);
}
