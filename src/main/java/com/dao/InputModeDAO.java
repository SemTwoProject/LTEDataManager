package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entity.InputMode;

@Local
public interface InputModeDAO {

	Collection<InputMode> getInputMode();
	InputMode getByInputMode(String input);
<<<<<<< HEAD
	void createInputMode(String input);
=======
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}
