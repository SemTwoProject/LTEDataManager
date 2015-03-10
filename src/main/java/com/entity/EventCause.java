package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@SuppressWarnings("serial")
@IdClass(EventCauseId.class)
@Entity
@Table(name = "event_cause")
public class EventCause implements Serializable {

	@Id
	@Column(name = "event_id")
	private Integer eventId;
	
	@Id
	@Column(name = "cause")
	private Integer causeCode;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "eventCause")
	private List<Fault> faultList = new ArrayList<Fault>();

	public EventCause() {
	}

	public EventCause(Integer causeCode, Integer eventId, String description) {
		this.causeCode = causeCode;
		this.eventId = eventId;
		this.description = description;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getEvent() {
		return causeCode;
	}

	public void setEvent(Integer causeCode) {
		this.causeCode = causeCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCauseCode() {
		return causeCode;
	}

	public void setCauseCode(Integer causeCode) {
		this.causeCode = causeCode;
	}
	@XmlTransient
	public List<Fault> getFaultList() {
		return faultList;
	}

	public void setFaultList(List<Fault> faultList) {
		this.faultList = faultList;
	}

	public void addFault(Fault fault) {
		fault.setEventCause(this);
		faultList.add(fault);
	}
}