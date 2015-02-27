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
@Table(name = "ne_version")
public class NEVersion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "ne")
<<<<<<< HEAD
	private Integer ne;
=======
	private String ne;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
	@OneToMany(mappedBy = "ne", cascade = CascadeType.ALL)
	private List<Fault> faultList = new ArrayList<Fault>();

	public NEVersion() {
	}

<<<<<<< HEAD
	public NEVersion(Integer ne) {
=======
	public NEVersion(String ne) {
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
		this.ne = ne;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

<<<<<<< HEAD
	public Integer getNe() {
		return ne;
	}

	public void setNe(Integer ne) {
=======
	public String getNe() {
		return ne;
	}

	public void setNe(String ne) {
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
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
