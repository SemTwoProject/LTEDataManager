package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
=======
import javax.persistence.*;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68

@SuppressWarnings("serial")
@Entity
@Table(name = "duration")
public class Duration implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "duration")
	private Integer duration;
	@OneToMany(mappedBy = "duration", cascade = CascadeType.ALL)
	private List<Fault> faultList = new ArrayList<Fault>();

	public Duration() {
	}

	public Duration(Integer duration) {
		this.duration = duration;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public List<Fault> getFaultList() {
		return faultList;
	}

	public void setFaultList(List<Fault> faultList) {
		this.faultList = faultList;
	}

	public void addFault(Fault fault) {
		fault.setDuration(this);
		faultList.add(fault);
	}
}
