package entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class CallFailure {

	// every entity requires an id, and we can make it auto generated
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int callFailureId;

	private Date date;
	private int duration;
	private int imsiId;
	private int causeId;
	private int failureId;
	private int cellId;
	private int tacId;
	private int marketId;

	public CallFailure() {

	}

	public CallFailure(Date date, int duration, int imsiId, int causeId,
			int failureId, int cellId, int tacId, int marketId) {
		super();
		this.date = date;
		this.duration = duration;
		this.imsiId = imsiId;
		this.causeId = causeId;
		this.failureId = failureId;
		this.cellId = cellId;
		this.tacId = tacId;
		this.marketId = marketId;
	}

	public int getCallFailureId() {
		return callFailureId;
	}

	public void setCallFailureId(int callFailureId) {
		this.callFailureId = callFailureId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getImsiId() {
		return imsiId;
	}

	public void setImsiId(int imsiId) {
		this.imsiId = imsiId;
	}

	public int getCauseId() {
		return causeId;
	}

	public void setCauseId(int causeId) {
		this.causeId = causeId;
	}

	public int getFailureId() {
		return failureId;
	}

	public void setFailureId(int failureId) {
		this.failureId = failureId;
	}

	public int getCellId() {
		return cellId;
	}

	public void setCellId(int cellId) {
		this.cellId = cellId;
	}

	public int getTacId() {
		return tacId;
	}

	public void setTacId(int tacId) {
		this.tacId = tacId;
	}

	public int getMarketId() {
		return marketId;
	}

	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}

}