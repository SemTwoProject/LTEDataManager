package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class CellHier {

	// every entity requires an id, and we can make it auto generated
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int cellId;
	private int hier3Id;
	private int hier32Id;
	private int hier321Id;

	public CellHier() {

	}

	public CellHier(int cellId, int hier3Id, int hier32Id, int hier321Id) {
		super();
		this.cellId = cellId;
		this.hier3Id = hier3Id;
		this.hier32Id = hier32Id;
		this.hier321Id = hier321Id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCellId() {
		return cellId;
	}

	public void setCellId(int cellId) {
		this.cellId = cellId;
	}

	public int getHier3Id() {
		return hier3Id;
	}

	public void setHier3Id(int hier3Id) {
		this.hier3Id = hier3Id;
	}

	public int getHier32Id() {
		return hier32Id;
	}

	public void setHier32Id(int hier32Id) {
		this.hier32Id = hier32Id;
	}

	public int getHier321Id() {
		return hier321Id;
	}

	public void setHier321Id(int hier321Id) {
		this.hier321Id = hier321Id;
	}

}