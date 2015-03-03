package dao;

import javax.ejb.Local;

import entities.MNC;

import java.util.Collection;
@Local
public interface MNCDAO {

	Collection<MNC> getMNC();
	MNC getByMNC(Integer mnc);
}
