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
@Table(name = "ue_type")
public class UEType implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "ue_type")
	private String ueType;

	@OneToMany(mappedBy = "ueType", cascade = CascadeType.ALL)
	private List<UE> ueList = new ArrayList<UE>();

	public UEType() {
	}

	public UEType(String ueType) {
		this.ueType = ueType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUeType() {
		return ueType;
	}

	public void setUeType(String ueType) {
		this.ueType = ueType;
	}

	public List<UE> getUeList() {
		return ueList;
	}

	public void setUeList(List<UE> ueList) {
		this.ueList = ueList;
	}

	public void addUE(UE ue) {
		ue.setUeType(this);
		ueList.add(ue);
	}
}
