package dao;

import javax.ejb.Local;

import entities.Duration;

import java.util.Collection;
@Local
public interface DurationDAO {

	Collection<Duration> getDuration();
	Duration getByDuration(Integer duration);
}