package com.dao;

<<<<<<< HEAD
import java.util.Collection;

import javax.ejb.Local;

import com.entity.Failure;
=======
import javax.ejb.Local;

import com.entity.Failure;
import com.entity.Fault;

import java.util.Collection;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public interface FailureDAO {

	Collection<Failure> getFailure();
	Failure getByFailure(Integer failure);
<<<<<<< HEAD
	public void createFailure(Integer failure, String description);
=======
	Collection<Object> getFailureByFault(Fault fault);
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}
