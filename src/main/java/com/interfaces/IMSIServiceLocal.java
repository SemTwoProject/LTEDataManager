package com.interfaces;

import java.util.Collection;

import com.entity.IMSI;

public interface IMSIServiceLocal {
	Collection<IMSI> getAllIMSI();
	Collection<Object> getAllFailureForIMSI(String imsi);
}
