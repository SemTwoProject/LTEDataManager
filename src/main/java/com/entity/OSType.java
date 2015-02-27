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
@Table(name = "os_type")
public class OSType implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "os")
	private String os;

	@OneToMany(mappedBy = "os", cascade = CascadeType.ALL)
	private List<UE> ueList = new ArrayList<UE>();

	public OSType() {
	}

	public OSType(String os) {
		this.os = os;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public List<UE> getUeList() {
		return ueList;
	}

	public void setUeList(List<UE> ueList) {
		this.ueList = ueList;
	}

	public void addUE(UE ue) {
		ue.setOs(this);
		ueList.add(ue);
	}
}
