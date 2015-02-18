package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "failure_class")
public class Failure implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "failure")
	private Integer failure;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "failure")
	private List<Fault> faultList = new ArrayList<Fault>();


	public Failure() {
	}

	public Failure(Integer failure, String description) {
		this.failure = failure;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getfailure() {
		return failure;
	}

	public void setfailure(Integer failure) {
		this.failure = failure;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Fault> getFaultList() {
		return faultList;
	}

	public void setFaultList(List<Fault> faultList) {
		this.faultList = faultList;
	}

	public void addFault(Fault fault) {
		fault.setFailure(this);
		faultList.add(fault);
	}
}
