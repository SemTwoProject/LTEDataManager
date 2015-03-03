package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.xml.bind.annotation.XmlTransient;

@SuppressWarnings("serial")
@Entity
@Table(name = "cause")
public class EventCause implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cause_id")
	private Integer causeid;
	
	@Column(name = "cause")
	private Integer cause;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "causeid")
	private List<Fault> faultList = new ArrayList<Fault>();

	public EventCause() {
	}

	public EventCause(Integer cause, String description) {
		this.cause = cause;
		this.description = description;
	}

	public Integer getId() {
		return causeid;
	}

	public void setId(Integer causeid) {
		this.causeid = causeid;
	}

	public Integer getEvent() {
		return cause;
	}

	public void setEvent(Integer cause) {
		this.cause = cause;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addFault(Fault fault) {
		fault.setEvent(this);
		faultList.add(fault);
	}
}