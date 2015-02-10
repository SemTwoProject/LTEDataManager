package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class UE {

	// every entity requires an id, and we can make it auto generated
	@Id
	private int tac;

	private String model;
	private String marketingName;
	private int osId;
	private int ueId;
	private int vendorId;
	private int inputModeId;

	public UE() {
	}

	public UE(String model, String marketingName, int osId, int ueId,
			int vendorId, int inputModeId) {
		super();
		this.model = model;
		this.marketingName = marketingName;
		this.osId = osId;
		this.ueId = ueId;
		this.vendorId = vendorId;
		this.inputModeId = inputModeId;
	}

	public int getTac() {
		return tac;
	}

	public void setTac(int tac) {
		this.tac = tac;
	}

	public String getMarketingName() {
		return marketingName;
	}

	public void setMarketingName(String marketingName) {
		this.marketingName = marketingName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getOsId() {
		return osId;
	}

	public void setOsId(int osId) {
		this.osId = osId;
	}

	public int getUeId() {
		return ueId;
	}

	public void setUeId(int ueId) {
		this.ueId = ueId;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getInputModeId() {
		return inputModeId;
	}

	public void setInputModeId(int inputModeId) {
		this.inputModeId = inputModeId;
	}

}