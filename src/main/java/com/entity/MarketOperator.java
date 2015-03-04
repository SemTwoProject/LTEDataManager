package com.entity;

import java.io.Serializable;

import javax.persistence.Column;


@SuppressWarnings("serial")
public class MarketOperator implements Serializable{

	@Column(name="mnc")
	private Integer mncId;
	@Column(name="mcc")
	private Integer mccId;
	
	public MarketOperator(){}

	public Integer getMncId() {
		return mncId;
	}


	public void setMncId(Integer mncId) {
		this.mncId = mncId;
	}


	public Integer getMccId() {
		return mccId;
	}


	public void setMccId(Integer mccId) {
		this.mccId = mccId;
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
		MarketOperator other = (MarketOperator) obj;
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
