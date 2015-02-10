package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class EventCode {

	// every entity requires an id, and we can make it auto generated
	@Id
	private int eventCauseId;

	private String description;

	public EventCode() {

	}

	public EventCode(int eventCauseId, String description) {
		super();
		this.eventCauseId = eventCauseId;
		this.description = description;
	}

	public int getEventCauseId() {
		return eventCauseId;
	}

	public void setEventCauseId(int eventCauseId) {
		this.eventCauseId = eventCauseId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}