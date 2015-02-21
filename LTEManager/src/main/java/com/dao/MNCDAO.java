package com.dao;

import javax.ejb.Local;

import com.entity.MNC;

import java.util.Collection;
@Local
public interface MNCDAO {

	Collection<MNC> getMNC();
	MNC getByMNC(Integer mnc);
}
