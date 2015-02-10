package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
		@NamedQuery(name = "Capability.findAllCapabilities", query = "select o from Capability o"),
		@NamedQuery(name = "Capability.findByDescription", query = "select o from Capability o where o.description=:description"), })
@Entity
public class Capability {

	// every entity requires an id, and we can make it auto generated
	@Id
	private int id;

	private String description;

	public Capability() {

	}

	public Capability(String description) {
		super();
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}