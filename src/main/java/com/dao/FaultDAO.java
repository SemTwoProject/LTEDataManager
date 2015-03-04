package com.dao;

import java.sql.Timestamp;
import java.util.Collection;

import javax.ejb.Local;

import com.entity.Fault;

@Local
public interface FaultDAO {

	Collection<Fault> getFault();

	Fault getById(Integer id);

	Collection<Fault> getFaultByIMSI(Long imsi);

	Collection<Object> getTotalFaultsAndDurationPerIMSI(Timestamp start, Timestamp end);
}