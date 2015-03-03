package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.MccMnc;

@Local
public interface MCCDAO {

	Collection<MccMnc> getMCC();
	MccMnc getByMCC(Integer mcc);
}
