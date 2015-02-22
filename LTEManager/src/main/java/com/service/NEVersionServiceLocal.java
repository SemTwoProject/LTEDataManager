package com.service;

import java.util.Collection;

import com.entity.NEVersion;

public interface NEVersionServiceLocal {
	Collection<NEVersion> getAllNEVersion();
	public void createNEVersions();
}
