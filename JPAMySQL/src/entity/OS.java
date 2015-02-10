package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class OS {

	// every entity requires an id, and we can make it auto generated
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String os;

	public OS() {

	}

	public OS(String os) {
		super();
		this.os = os;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

}