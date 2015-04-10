package com.dao;

import javax.ejb.Local;

@Local
public interface ExcelDAO {

	public void callAll(String fileName);
}