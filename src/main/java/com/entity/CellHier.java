package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "cell")
public class CellHier implements Serializable {

	@Id
	@Column(name = "cell")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cellId == null) ? 0 : cellId.hashCode());
		result = prime * result
				+ ((faultList == null) ? 0 : faultList.hashCode());
		result = prime * result
				+ ((hier321Id == null) ? 0 : hier321Id.hashCode());
		result = prime * result
				+ ((hier32Id == null) ? 0 : hier32Id.hashCode());
		result = prime * result + ((hier3Id == null) ? 0 : hier3Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CellHier other = (CellHier) obj;
		if (cellId == null) {
			if (other.cellId != null)
				return false;
		} else if (!cellId.equals(other.cellId))
			return false;
		if (faultList == null) {
			if (other.faultList != null)
				return false;
		} else if (!faultList.equals(other.faultList))
			return false;
		if (hier321Id == null) {
			if (other.hier321Id != null)
				return false;
		} else if (!hier321Id.equals(other.hier321Id))
			return false;
		if (hier32Id == null) {
			if (other.hier32Id != null)
				return false;
		} else if (!hier32Id.equals(other.hier32Id))
			return false;
		if (hier3Id == null) {
			if (other.hier3Id != null)
				return false;
		} else if (!hier3Id.equals(other.hier3Id))
			return false;
		return true;
	}
	
}
