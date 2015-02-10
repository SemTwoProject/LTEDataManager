package entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Failure {

	// every entity requires an id, and we can make it auto generated
	@Id
	private int failureId;

	private String description;

	public Failure() {

	}

	public Failure(int failureId, String description) {
		super();
		this.failureId = failureId;
		this.description = description;
	}

	public int getFailureId() {
		return failureId;
	}

	public void setFailureId(int failureId) {
		this.failureId = failureId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}