package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.Duration;
@Local
public interface DurationDAO {

	Collection<Duration> getDuration();
	Duration getByDuration(Integer duration);
	public void createDuration(Integer duration);
}
