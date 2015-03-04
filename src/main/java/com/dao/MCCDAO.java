<<<<<<< HEAD
package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.MccMnc;

@Local
public interface MCCDAO {

	Collection<MccMnc> getMCC();
	MccMnc getByMCC(Integer mcc);
}
=======
package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.MccMnc;

@Local
public interface MCCDAO {

	Collection<MccMnc> getMCC();
	MccMnc getByMCC(Integer mcc);
}
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
