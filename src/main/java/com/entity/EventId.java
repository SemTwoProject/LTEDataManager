package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "event_id")
public class EventId implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "event_id")
	private Integer eventId;

	@OneToMany(mappedBy = "eventId", cascade = CascadeType.ALL)
	private List<EventCause> eventCauses = new ArrayList<EventCause>();

	@OneToMany(mappedBy = "eventId", cascade = CascadeType.ALL)
	private List<Fault> faultList = new ArrayList<Fault>();

	public EventId() {
	}

	public EventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public List<EventCause> getEventCauses() {
		return eventCauses;
	}

	public void setEventCauses(List<EventCause> eventCauses) {
		this.eventCauses = eventCauses;
	}

	public List<Fault> getFaultList() {
		return faultList;
	}

	public void setFaultList(List<Fault> faultList) {
		this.faultList = faultList;
	}

	public void addMNC(EventCause eventCause) {
		eventCause.setEventId(this);
		eventCauses.add(eventCause);
	}

	public void addFault(Fault fault) {
		fault.setEventId(this);
		faultList.add(fault);
	}
}