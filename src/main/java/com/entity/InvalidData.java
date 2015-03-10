package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "invalid")
public class InvalidData implements Serializable {

	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "date_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@Column(name = "eventId")
	private Integer eventId;
	@Column(name = "failure")
	private Integer failure;
	@Column(name = "ue_type")
	private Integer ueType;
	@Column(name = "market")
	private Integer market;
	@Column(name = "operator")
	private Integer operator;
	@Column(name = "cell")
	private Integer cell;
	@Column(name = "duration")
	private Integer duration;
	@Column(name = "cause_code")
	private Integer causeCode;
	@Column(name = "ne")
	private String neVersion;
	@Column(name = "imsi")
	private Long imsi;
	@Column(name = "hier3_id")
	private Long hier3Id;
	@Column(name = "hier32_id")
	private Long hier32Id;
	@Column(name = "hier321_id")
	private Long hier321Id;

	public InvalidData() {
	}

	public InvalidData(Date date, Integer eventId, Integer failure,
			Integer ueType, Integer market, Integer operator, Integer cell,
			Integer duration, Integer causeCode, String neVersion, Long imsi,
			Long hier3Id, Long hier32Id, Long hier321Id) {
		this.date = date;
		this.eventId = eventId;
		this.failure = failure;
		this.ueType = ueType;
		this.market = market;
		this.operator = operator;
		this.cell = cell;
		this.duration = duration;
		this.causeCode = causeCode;
		this.neVersion = neVersion;
		this.imsi = imsi;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getFailure() {
		return failure;
	}

	public void setFailure(Integer failure) {
		this.failure = failure;
	}

	public Integer getUeType() {
		return ueType;
	}

	public void setUeType(Integer ueType) {
		this.ueType = ueType;
	}

	public Integer getMarket() {
		return market;
	}

	public void setMarket(Integer market) {
		this.market = market;
	}

	public Integer getOperator() {
		return operator;
	}

	public void setOperator(Integer operator) {
		this.operator = operator;
	}

	public Integer getCell() {
		return cell;
	}

	public void setCell(Integer cell) {
		this.cell = cell;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getCauseCode() {
		return causeCode;
	}

	public void setCauseCode(Integer causeCode) {
		this.causeCode = causeCode;
	}

	public String getNeVersion() {
		return neVersion;
	}

	public void setNeVersion(String neVersion) {
		this.neVersion = neVersion;
	}

	public Long getImsi() {
		return imsi;
	}

	public void setImsi(Long imsi) {
		this.imsi = imsi;
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

}