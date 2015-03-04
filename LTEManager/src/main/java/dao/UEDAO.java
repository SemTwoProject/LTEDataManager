package dao;

import java.util.Collection;

import javax.ejb.Local;

import entities.UE;

@Local
public interface UEDAO {

	Collection<UE> getUE();
	UE getByTac(Integer tac);
}
