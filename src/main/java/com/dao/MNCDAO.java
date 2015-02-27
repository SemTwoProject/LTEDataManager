package com.dao;

<<<<<<< HEAD
import java.util.Collection;

=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
import javax.ejb.Local;

import com.entity.MCC;
import com.entity.MNC;
<<<<<<< HEAD
=======

import java.util.Collection;

>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public interface MNCDAO {

	Collection<MNC> getMNC();
<<<<<<< HEAD
	MNC getByMNC(Integer mnc);
	void createMNC(Integer mnc, String operator, MCC mcc);
=======

	MNC getByMNC(Integer mnc);

	MCC getByMCC(Integer mcc);
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}
