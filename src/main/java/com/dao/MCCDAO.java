package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.MCC;

@Local
public interface MCCDAO {

	Collection<MCC> getMCC();
	MCC getByMCC(Integer mcc);
<<<<<<< HEAD
	void createMCC(Integer mcc, String country);

=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}
