package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entities.MCC;

@Local
public interface MCCDAO {

	Collection<MCC> getMCC();
	MCC getByMCC(Integer mcc);
	void createMCC(Integer mcc, String country);

}
