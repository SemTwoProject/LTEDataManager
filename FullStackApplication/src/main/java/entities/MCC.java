package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "mcc_table")
public class MCC implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "mcc")
	private Integer mcc;
	@Column(name = "country")
	private String country;
	@OneToMany(mappedBy = "mcc", cascade=CascadeType.ALL)
	private List<MNC> mncOperators = new ArrayList<MNC>();
	@OneToMany(mappedBy = "mcc")
	private List<Fault> faultList = new ArrayList<Fault>();

	public MCC() {
		// TODO Auto-generated constructor stub
	}

	public MCC(Integer mcc, String country) {
		this.mcc = mcc;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMcc() {
		return mcc;
	}

	public void setMcc(Integer mcc) {
		this.mcc = mcc;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<MNC> getMncOperators() {
		return mncOperators;
	}

	public void setMncOperators(List<MNC> mncOperators) {
		this.mncOperators = mncOperators;
	}
 
	public void addMNC(MNC mnc) {
		mnc.setMcc(this);
		mncOperators.add(mnc);
	}
	public void addFault(Fault fault) {
		fault.setMcc(this);
		faultList.add(fault);
	}
}
