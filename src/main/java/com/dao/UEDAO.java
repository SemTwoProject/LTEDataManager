package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.UE;

@Local
public interface UEDAO {

	Collection<UE> getUE();

	UE getByTac(Integer tac);
}
