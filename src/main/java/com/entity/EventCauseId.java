package com.entity;

import java.io.Serializable;

import javax.persistence.Column;


@SuppressWarnings("serial")
public class EventCauseId implements Serializable{

	@Column(name="cause")
	private Integer causeCode;
	@Column(name="event_id")
	private Integer eventId;
	
	public EventCauseId(){}
	
	

	public Integer getCauseCode() {
		return causeCode;
	}



	public void setCauseCode(Integer causeCode) {
		this.causeCode = causeCode;
	}



	public Integer getEventId() {
		return eventId;
	}



	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((causeCode == null) ? 0 : causeCode.hashCode());
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventCauseId other = (EventCauseId) obj;
		if (causeCode == null) {
			if (other.causeCode != null)
				return false;
		} else if (!causeCode.equals(other.causeCode))
			return false;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		return true;
	}
	
	
}
