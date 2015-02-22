package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.MCC;

@Local
public interface MCCDAO {

	Collection<MCC> getMCC();
	MCC getByMCC(Integer mcc);
	public void createMCCs();
}
