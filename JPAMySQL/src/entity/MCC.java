package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class MCC {

	// every entity requires an id, and we can make it auto generated
	@Id
	private int mccId;

	private String country;

	public MCC() {

	}

	public MCC(int mccId, String country) {
		super();
		this.mccId = mccId;
		this.country = country;
	}

	public int getMccId() {
		return mccId;
	}

	public void setMccId(int mccId) {
		this.mccId = mccId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}