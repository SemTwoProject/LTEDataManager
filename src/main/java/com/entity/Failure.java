<<<<<<< HEAD
package com.entity;

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
	@Column(name = "failure_id")
	private Integer failureid;

	@Column(name = "failure")
	private Integer failure;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "failureid")
	private List<Fault> faultList = new ArrayList<Fault>();


	public Failure() {
	}

	public Failure(Integer failure, String description) {
		this.failure = failure;
		this.description = description;
	}

	public Integer getId() {
		return failureid;
	}

	public void setId(Integer failureid) {
		this.failureid = failureid;
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
=======
package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "failure")
public class Failure implements Serializable {


	@Id
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((failure == null) ? 0 : failure.hashCode());
		result = prime * result
				+ ((faultList == null) ? 0 : faultList.hashCode());
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
		Failure other = (Failure) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (failure == null) {
			if (other.failure != null)
				return false;
		} else if (!failure.equals(other.failure))
			return false;
		if (faultList == null) {
			if (other.faultList != null)
				return false;
		} else if (!faultList.equals(other.faultList))
			return false;
		return true;
	}
	
}
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
