package com.service;

import java.util.Collection;

import com.entity.MNC;

public interface MNCServiceLocal {
	Collection<MNC> getAllMNC();
	public void createMNCs();
}