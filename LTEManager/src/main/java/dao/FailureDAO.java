package dao;

import javax.ejb.Local;

import entities.Failure;

import java.util.Collection;
@Local
public interface FailureDAO {

	Collection<Failure> getFailure();
	Failure getByFailure(Integer failure);
}
