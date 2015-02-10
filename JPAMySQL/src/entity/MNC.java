package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class MNC {

	// every entity requires an id, and we can make it auto generated
	@Id
	private int mncId;

	private String operator;
	private int mcc;

	public MNC() {

	}

	public MNC(int mncId, String operator, int mcc) {
		super();
		this.mncId = mncId;
		this.operator = operator;
		this.mcc = mcc;
	}

	public int getMncId() {
		return mncId;
	}

	public void setMncId(int mncId) {
		this.mncId = mncId;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public int getMcc() {
		return mcc;
	}

	public void setMcc(int mcc) {
		this.mcc = mcc;
	}

}