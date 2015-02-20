package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "ne_version")
public class NEVersion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "ne")
	private Integer ne;
	@OneToMany(mappedBy = "ne", cascade = CascadeType.ALL)
	private List<Fault> faultList = new ArrayList<Fault>();

	public NEVersion() {
	}

	public NEVersion(Integer ne) {
		this.ne = ne;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNe() {
		return ne;
	}

	public void setNe(Integer ne) {
		this.ne = ne;
	}

	public List<Fault> getFaultList() {
		return faultList;
	}

	public void setFaultList(List<Fault> faultList) {
		this.faultList = faultList;
	}

	public void addFault(Fault fault) {
		fault.setNe(this);
		faultList.add(fault);
	}
}
