package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@Entity
public class EventCause {

	// every entity requires an id, and we can make it auto generated
	@Id
	private int causeId;

	private int eventCauseId;

	public EventCause() {

	}

	public EventCause(int causeId, int eventCauseId) {
		super();
		this.causeId = causeId;
		this.eventCauseId = eventCauseId;
	}

	public int getCauseId() {
		return causeId;
	}

	public void setCauseId(int causeId) {
		this.causeId = causeId;
	}

	public int getEventCauseId() {
		return eventCauseId;
	}

	public void setEventCauseId(int eventCauseId) {
		this.eventCauseId = eventCauseId;
	}

}