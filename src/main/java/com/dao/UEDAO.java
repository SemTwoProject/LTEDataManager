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

	UEType getByUEType(String ue);

	OSType getByOSType(String os);

	InputMode getByInputMode(String input);

}
