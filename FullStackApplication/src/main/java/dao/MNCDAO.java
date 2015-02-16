package dao;

import javax.ejb.Local;

import java.util.Collection;

import entities.MCC;
import entities.MNC;
@Local
public interface MNCDAO {

	Collection<MNC> getMNC();
	MNC getByMNC(Integer mnc);
	void createMNC(Integer mnc, String operator, MCC mcc);
}
