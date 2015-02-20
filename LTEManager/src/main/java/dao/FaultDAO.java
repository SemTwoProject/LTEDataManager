package dao;

import javax.ejb.Local;

import entities.Fault;

import java.util.Collection;

@Local
public interface FaultDAO {

	Collection<Fault> getFault();

	Fault getById(Integer id);
}
