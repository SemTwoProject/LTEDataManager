<<<<<<< HEAD
package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.UE;

@Local
public interface UEDAO {

	Collection<UE> getUE();

	UE getByTac(Integer tac);
}
=======
package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.UE;

@Local
public interface UEDAO {

	Collection<UE> getUE();

	UE getByTac(Integer tac);
}
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
