package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.Fault;

@Local
public interface UEDAO {

	Collection<Fault> getEventCausePerModel(String model);
}