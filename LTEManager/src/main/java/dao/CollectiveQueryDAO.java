package dao;

import javax.ejb.Local;

import entities.Fault;

import java.util.Collection;
@Local
public interface CollectiveQueryDAO {

	Collection<Object> getEventCauseAndFailures(Fault fault);
}