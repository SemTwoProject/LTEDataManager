package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class InputMode {

	// every entity requires an id, and we can make it auto generated
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int inputModeId;

	private String inputMode;

	public InputMode() {

	}

	public InputMode(String inputMode) {
		super();
		this.inputMode = inputMode;
	}

	public int getInputModeId() {
		return inputModeId;
	}

	public void setInputModeId(int inputModeId) {
		this.inputModeId = inputModeId;
	}

	public String getInputMode() {
		return inputMode;
	}

	public void setInputMode(String inputMode) {
		this.inputMode = inputMode;
	}

}