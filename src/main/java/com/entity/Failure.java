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
		result = prime * result + ((failure == null) ? 0 : failure.hashCode());
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
		if (failure == null) {
			if (other.failure != null)
				return false;
		} else if (!failure.equals(other.failure))
			return false;
		return true;
	}

}
