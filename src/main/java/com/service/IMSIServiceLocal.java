package com.service;

import java.util.Collection;

import com.entity.IMSI;

public interface IMSIServiceLocal {
	Collection<IMSI> getAllIMSI();
	IMSI getByIMSI(Long imsi);
}
