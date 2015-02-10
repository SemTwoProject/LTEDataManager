package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class UEType {

	// every entity requires an id, and we can make it auto generated
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String ueType;

	public UEType() {

	}

	public UEType(String ueType) {
		super();
		this.ueType = ueType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUeType() {
		return ueType;
	}

	public void setUeType(String ueType) {
		this.ueType = ueType;
	}

}