package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class IMSI {

	// every entity requires an id, and we can make it auto generated
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int imsiId;

	private int imsi;

	public IMSI() {

	}

	public IMSI(int imsi) {
		super();
		this.imsi = imsi;
	}

	public int getImsiId() {
		return imsiId;
	}

	public void setImsiId(int imsiId) {
		this.imsiId = imsiId;
	}

	public int getImsi() {
		return imsi;
	}

	public void setImsi(int imsi) {
		this.imsi = imsi;
	}

}