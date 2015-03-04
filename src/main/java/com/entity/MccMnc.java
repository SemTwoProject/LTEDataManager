package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@SuppressWarnings("serial")
@IdClass(MarketOperator.class)
@Entity
@Table(name = "mcc")
public class MccMnc implements Serializable {

	@Id
	@Column(name = "mcc")
	private Integer mccId;
	
	@Id
	@Column(name = "mnc")
	private Integer mncId;

	@Column(name = "country")
	private String country;

	@Column(name = "operator")
	private String operator;
	
	@OneToMany(mappedBy = "mccid")
	private List<Fault> faultList = new ArrayList<Fault>();

	public MccMnc() {
	}

	public MccMnc(Integer mcc, String country, Integer mnc, String operator) {
		this.mccId = mcc;
		this.country = country;
		this.mncId = mnc;
		this.operator = operator;
	}

	public Integer getMccId() {
		return mccId;
	}

	public void setMccId(Integer mccId) {
		this.mccId = mccId;
	}

	public Integer getMncId() {
		return mncId;
	}

	public void setMncId(Integer mncId) {
		this.mncId = mncId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@XmlTransient
	public List<Fault> getFaultList() {
		return faultList;
	}

	public void setFaultList(List<Fault> faultList) {
		this.faultList = faultList;
	}

	public void addFault(Fault fault) {
		fault.setMccid(this);
		faultList.add(fault);
	}
}
