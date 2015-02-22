package com.dao;

import javax.ejb.Local;

import com.entity.Duration;

import java.util.Collection;
@Local
public interface DurationDAO {

	Collection<Duration> getDuration();
	Duration getByDuration(Integer duration);
	public void createDurations();
}