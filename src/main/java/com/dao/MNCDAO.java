package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.MCC;
import com.entity.MNC;
@Local
public interface MNCDAO {

	Collection<MNC> getMNC();
	MNC getByMNC(Integer mnc);
	void createMNC(Integer mnc, String operator, MCC mcc);
}
