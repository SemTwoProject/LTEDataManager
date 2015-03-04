package dao;

import java.util.Collection;

import javax.ejb.Local;

import entities.MCC;

@Local
public interface MCCDAO {

	Collection<MCC> getMCC();
	MCC getByMCC(Integer mcc);
}
