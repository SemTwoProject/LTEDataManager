package dao;

import javax.ejb.Local;

import java.util.Collection;
import entities.Duration;
@Local
public interface DurationDAO {

	Collection<Duration> getDuration();
	Duration getByDuration(Integer duration);
	void createDuration(Integer duration);
}
