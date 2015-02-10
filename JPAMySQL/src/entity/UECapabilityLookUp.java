package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class UECapabilityLookUp {

	// every entity requires an id, and we can make it auto generated

	@Id
	private int lookupId;
	private int tac;
	private int capabilityId;

	public UECapabilityLookUp() {

	}

	public UECapabilityLookUp(int tac, int capabilityId) {
		super();
		this.tac = tac;
		this.capabilityId = capabilityId;
	}

	public int getLookupId() {
		return lookupId;
	}

	public void setLookupId(int lookupId) {
		this.lookupId = lookupId;
	}

	public int getTac() {
		return tac;
	}

	public int getId() {
		return tac;
	}

	public void setTac(int tac) {
		this.tac = tac;
	}

	public int getCapabilityId() {
		return capabilityId;
	}

	public void setCapabilityId(int capabilityId) {
		this.capabilityId = capabilityId;
	}

}