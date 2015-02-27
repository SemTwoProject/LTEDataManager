package com.dao;

<<<<<<< HEAD
import java.util.Collection;

import javax.ejb.Local;

import com.entity.Duration;
=======
import javax.ejb.Local;

import com.entity.Duration;

import java.util.Collection;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
@Local
public interface DurationDAO {

	Collection<Duration> getDuration();
	Duration getByDuration(Integer duration);
<<<<<<< HEAD
	public void createDuration(Integer duration);
}
=======
}
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
