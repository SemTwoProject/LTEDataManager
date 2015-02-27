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
@Table(name = "input_mode")
public class InputMode implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "input_mode", nullable = false, unique = true)
	private String inputMode;

	@OneToMany(mappedBy = "inputMode", cascade = CascadeType.ALL)
	private List<UE> ueList = new ArrayList<UE>();

	public InputMode() {
	}

	public InputMode(String inputMode) {
		this.inputMode = inputMode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInputMode() {
		return inputMode;
	}

	public void setInputMode(String inputMode) {
		this.inputMode = inputMode;
	}

	public List<UE> getUeList() {
		return ueList;
	}

	public void setUeList(List<UE> ueList) {
		this.ueList = ueList;
	}

	public void addUE(UE ue) {
		ue.setInputMode(this);
		ueList.add(ue);
	}
}
