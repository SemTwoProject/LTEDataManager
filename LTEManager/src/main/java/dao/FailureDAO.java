package dao;

import javax.ejb.Local;

import entities.Failure;
import entities.Fault;

import java.util.Collection;
@Local
public interface FailureDAO {

	Collection<Failure> getFailure();
	Failure getByFailure(Integer failure);
	Collection<Object> getFailureByFault(Fault fault);
}
