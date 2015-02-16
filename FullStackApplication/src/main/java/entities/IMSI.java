package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "imsi")
public class IMSI implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "imsi")
	private Long imsi;
	@OneToMany(mappedBy = "imsi", cascade = CascadeType.ALL)
	private List<Fault> faultList = new ArrayList<Fault>();

	public IMSI() {
		// TODO Auto-generated constructor stub
	}

	public IMSI(Long imsi) {
		this.imsi = imsi;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getImsi() {
		return imsi;
	}

	public void setImsi(Long imsi) {
		this.imsi = imsi;
	}

	public List<Fault> getFaultList() {
		return faultList;
	}

	public void setFaultList(List<Fault> faultList) {
		this.faultList = faultList;
	}

	public void addFault(Fault fault) {
		fault.setImsi(this);
		faultList.add(fault);
	}
}