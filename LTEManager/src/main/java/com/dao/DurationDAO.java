package com.dao;

import javax.ejb.Local;

import com.entities.Duration;

import java.util.Collection;
@Local
public interface DurationDAO {

	Collection<Duration> getDuration();
	Duration getByDuration(Integer duration);
	void createDuration(Integer duration);
}
