package dao;

import javax.ejb.Local;

import java.util.Collection;

import entities.Failure;
@Local
public interface FailureDAO {

	Collection<Failure> getFailure();
	Failure getByFailure(Integer failure);
	public void createFailure(Integer failure, String description);
}
