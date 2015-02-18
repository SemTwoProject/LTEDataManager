package com.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.entities.InputMode;

@Local
public interface InputModeDAO {

	Collection<InputMode> getInputMode();
	InputMode getByInputMode(String input);
	void createInputMode(String input);
}
