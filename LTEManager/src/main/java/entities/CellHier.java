package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "cell")
public class CellHier implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "cell_id")
	private Integer cellId;
	@Column(name = "hier3_id")
	private Long hier3Id;
	@Column(name = "hier32_id")
	private Long hier32Id;
	@Column(name = "hier321_id")
	private Long hier321Id;

	@OneToMany(mappedBy = "cell", cascade = CascadeType.ALL)
	private List<Fault> faultList = new ArrayList<Fault>();

	public CellHier() {
	}

	public CellHier(Integer cellId, Long hier3Id, Long hier32Id, Long hier321Id) {
		this.cellId = cellId;
		this.hier3Id = hier3Id;
		this.hier32Id = hier32Id;
		this.hier321Id = hier321Id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCellId() {
		return cellId;
	}

	public void setCellId(Integer cellId) {
		this.cellId = cellId;
	}

	public Long getHier3Id() {
		return hier3Id;
	}

	public void setHier3Id(Long hier3Id) {
		this.hier3Id = hier3Id;
	}

	public Long getHier32Id() {
		return hier32Id;
	}

	public void setHier32Id(Long hier32Id) {
		this.hier32Id = hier32Id;
	}

	public Long getHier321Id() {
		return hier321Id;
	}

	public void setHier321Id(Long hier321Id) {
		this.hier321Id = hier321Id;
	}

	public List<Fault> getFaultList() {
		return faultList;
	}

	public void setFaultList(List<Fault> faultList) {
		this.faultList = faultList;
	}

	public void addFault(Fault fault) {
		fault.setCell(this);
		faultList.add(fault);
	}
	/*public List<Fault> getFaultList() {
		return faultList;
	}

	public void setFaultList(List<Fault> faultList) {
		this.faultList = faultList;
	}

	public void addFault(Fault fault) {
		fault.setCellId(this);
		faultList.add(fault);
	}*/
}
