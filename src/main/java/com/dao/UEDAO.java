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
<<<<<<< HEAD
	UE getByTac(Integer tac);
	void createUE(Integer tac, String marketingName, String manufacturer,
			String accessCapability, String model, String vendorName,
			OSType os, InputMode inputMode, UEType ueType);
=======

	UE getByTac(Integer tac);

	UEType getByUEType(String ue);

	OSType getByOSType(String os);

	InputMode getByInputMode(String input);

>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}
