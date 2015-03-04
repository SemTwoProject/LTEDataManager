package dao;

import java.util.Collection;

import javax.ejb.Local;

import entities.InputMode;

@Local
public interface InputModeDAO {

	Collection<InputMode> getInputMode();
	InputMode getByInputMode(String input);
}
