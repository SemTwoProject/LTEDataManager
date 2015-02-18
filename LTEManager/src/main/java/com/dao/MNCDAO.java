package com.dao;

import javax.ejb.Local;

import com.entities.MCC;
import com.entities.MNC;

import java.util.Collection;
@Local
public interface MNCDAO {

	Collection<MNC> getMNC();
	MNC getByMNC(Integer mnc);
	void createMNC(Integer mnc, String operator, MCC mcc);
}
