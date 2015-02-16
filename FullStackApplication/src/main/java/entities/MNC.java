package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
public class MNC implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "mnc")
	private Integer mnc;
	@Column(name = "operator")
	private String operator;
	@JoinColumn(name = "mcc", referencedColumnName = "mcc", nullable = false)
	@ManyToOne
	private MCC mcc;
	@OneToMany(mappedBy = "mnc")
	private List<Fault> faultList = new ArrayList<Fault>();

	public MNC() {
		// TODO Auto-generated constructor stub
	}

	public MNC(Integer mnc, String operator, MCC mcc) {
		this.mnc = mnc;
		this.operator = operator;
		this.mcc = mcc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMnc() {
		return mnc;
	}

	public void setMnc(Integer mnc) {
		this.mnc = mnc;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@XmlTransient
	public MCC getMcc() {
		return mcc;
	}

	public void setMcc(MCC mcc) {
		this.mcc = mcc;
	}
	public void addFault(Fault fault) {
		fault.setMnc(this);
		faultList.add(fault);
	}
	
}
