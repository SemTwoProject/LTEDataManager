package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ue")
public class UE implements Serializable {

	@Id
	@Column(name = "tac")
	private Integer tac;
	@Column(name = "marketing_name")
	private String marketingName;
	@Column(name = "manufacturer")
	private String manufacturer;
	@Column(name = "access_capability")
	private String accessCapability;
	@Column(name = "model")
	private String model;
	@Column(name = "vendor_name")
	private String vendorName;
	
	@OneToMany(mappedBy = "tac", cascade = CascadeType.ALL)
	private List<Fault> faultList = new ArrayList<Fault>();
	@Column(name = "ue_type")
	private String ueType;
	@Column(name = "os")
	private String os;
	@Column(name = "input_mode")
	private String inputMode;

	public UE() {
	}

	public UE(Integer tac, String marketingName, String manufacturer,
			String accessCapability, String model, String vendorName,
			String os, String inputMode, String ueType) {
		this.tac = tac;
		this.marketingName = marketingName;
		this.manufacturer = manufacturer;
		this.accessCapability = accessCapability;
		this.model = model;
		this.vendorName = vendorName;
		this.os = os;
		this.inputMode = inputMode;
		this.ueType = ueType;
	}

	public Integer getTac() {
		return tac;
	}

	public void setTac(Integer tac) {
		this.tac = tac;
	}

	public String getMarketingName() {
		return marketingName;
	}

	public void setMarketingName(String marketingName) {
		this.marketingName = marketingName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getAccessCapability() {
		return accessCapability;
	}

	public void setAccessCapability(String accessCapability) {
		this.accessCapability = accessCapability;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getUeType() {
		return ueType;
	}

	public void setUeType(String ueType) {
		this.ueType = ueType;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getInputMode() {
		return inputMode;
	}

	public void setInputMode(String inputMode) {
		this.inputMode = inputMode;
	}
	
	public void addFault(Fault fault) {
		fault.setTac(this);
		faultList.add(fault);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tac == null) ? 0 : tac.hashCode());
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
		UE other = (UE) obj;
		if (tac == null) {
			if (other.tac != null)
				return false;
		} else if (!tac.equals(other.tac))
			return false;
		return true;
	}
	
}
