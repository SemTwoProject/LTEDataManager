package com.dao;

import javax.ejb.Local;

import com.entity.Fault;

import java.util.Collection;

@Local
public interface FaultDAO {

	Collection<Fault> getFault();

	Fault getById(Integer id);
	Fault getFaultByIMSI(Long imsi);
}
