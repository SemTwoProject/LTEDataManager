package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@SuppressWarnings("serial")
@Entity
@Table(name = "mnc_table")
public class UE implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
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
	
	//Foreign Keys
	@JoinColumn(name = "ue_type", referencedColumnName = "ue_type", nullable = false)
	@ManyToOne
	private UEType ueType;
	@JoinColumn(name = "os", referencedColumnName = "os", nullable = false)
	@ManyToOne
	private OSType os;
	@JoinColumn(name = "input_mode", referencedColumnName = "input_mode", nullable = false)
	@ManyToOne
	private InputMode inputMode;

	public UE() {
		// TODO Auto-generated constructor stub
	}

	public UE(Integer tac, String marketingName, String manufacturer,
			String accessCapability, String model, String vendorName,
			OSType os, InputMode inputMode, UEType ueType) {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@XmlTransient
	public UEType getUeType() {
		return ueType;
	}

	public void setUeType(UEType ueType) {
		this.ueType = ueType;
	}

	@XmlTransient
	public OSType getOs() {
		return os;
	}

	public void setOs(OSType os) {
		this.os = os;
	}

	@XmlTransient
	public InputMode getInputMode() {
		return inputMode;
	}

	public void setInputMode(InputMode inputMode) {
		this.inputMode = inputMode;
	}
	
	public void addFault(Fault fault) {
		fault.setTac(this);
		faultList.add(fault);
	}

}
