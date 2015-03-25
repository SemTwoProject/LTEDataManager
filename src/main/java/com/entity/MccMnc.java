package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	
	@OneToMany(mappedBy = "mccid", cascade = CascadeType.ALL)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mccId == null) ? 0 : mccId.hashCode());
		result = prime * result + ((mncId == null) ? 0 : mncId.hashCode());
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
		MccMnc other = (MccMnc) obj;
		if (mccId == null) {
			if (other.mccId != null)
				return false;
		} else if (!mccId.equals(other.mccId))
			return false;
		if (mncId == null) {
			if (other.mncId != null)
				return false;
		} else if (!mncId.equals(other.mncId))
			return false;
		return true;
	}
	
}
