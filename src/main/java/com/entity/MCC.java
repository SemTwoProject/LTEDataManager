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
@Table(name = "mcc")
public class MCC implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "mcc")
	private Integer mcc;
	@Column(name = "country")
	private String country;
	@OneToMany(mappedBy = "mcc", cascade=CascadeType.ALL)
	private List<MNC> mncOperators = new ArrayList<MNC>();
	@OneToMany(mappedBy = "mcc")
	private List<Fault> faultList = new ArrayList<Fault>();

	public MCC() {
	}

	public MCC(Integer mcc, String country) {
		this.mcc = mcc;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMcc() {
		return mcc;
	}

	public void setMcc(Integer mcc) {
		this.mcc = mcc;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<MNC> getMncOperators() {
		return mncOperators;
	}

	public void setMncOperators(List<MNC> mncOperators) {
		this.mncOperators = mncOperators;
	}
 
	public void addMNC(MNC mnc) {
		mnc.setMcc(this);
		mncOperators.add(mnc);
	}
	public void addFault(Fault fault) {
		fault.setMcc(this);
		faultList.add(fault);
	}
}
