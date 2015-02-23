package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

@SuppressWarnings("serial")
@Entity
@Table(name = "faults")
public class Fault implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "date_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@JoinColumn(name = "event_id", referencedColumnName = "event_id", nullable = false)
	@ManyToOne
	private EventId eventId;
	@JoinColumn(name = "failure", referencedColumnName = "failure", nullable = false)
	@ManyToOne
	private Failure failure;
	@JoinColumn(name = "tac", referencedColumnName = "tac", nullable = false)
	@ManyToOne
	private UE tac;
	@JoinColumn(name = "market", referencedColumnName = "mcc", nullable = false)
	@ManyToOne
	private MCC mcc;
	@JoinColumn(name = "operator", referencedColumnName = "mnc", nullable = false)
	@ManyToOne
	private MNC mnc;
	@JoinColumn(name = "duration", referencedColumnName = "duration", nullable = false)
	@ManyToOne
	private Duration duration;
	@JoinColumn(name = "cause", referencedColumnName = "cause", nullable = false)
	@ManyToOne
	private EventCause cause;
	@JoinColumn(name = "ne", referencedColumnName = "ne", nullable = false)
	@ManyToOne
	private NEVersion ne;
	@JoinColumn(name = "imsi", referencedColumnName = "imsi", nullable = false)
	@ManyToOne
	private IMSI imsi;
	@JoinColumn(name = "cell_id", referencedColumnName = "cell_id", nullable = false)
	@ManyToOne
	private CellHier cell;

	public Fault() {
	}
	
	public Fault(Date date, EventId eventId, Failure failure, UE tac,
			MCC mcc, MNC mnc, CellHier cell, Duration duration,
			EventCause eventCause, NEVersion ne, IMSI imsi) {
		this.date = date;
		this.eventId = eventId;
		this.failure = failure;
		this.tac = tac;
		this.mcc = mcc;
		this.mnc = mnc;
		this.cell = cell;
		this.duration = duration;
		this.cause = eventCause;
		this.ne = ne;
		this.imsi = imsi;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setDate(Date date) {
		this.date = date;
	}

	@XmlTransient
	public EventId getEventId() {
		return eventId;
	}

	public void setEventId(EventId eventId) {
		this.eventId = eventId;
	}

	@XmlTransient
	public Failure getFailure() {
		return failure;
	}

	public void setFailure(Failure failure) {
		this.failure = failure;
	}

	@XmlTransient
	public UE getTac() {
		return tac;
	}

	public void setTac(UE tac) {
		this.tac = tac;
	}

	@XmlTransient
	public MCC getMcc() {
		return mcc;
	}

	public void setMcc(MCC mcc) {
		this.mcc = mcc;
	}

	@XmlTransient
	public MNC getMnc() {
		return mnc;
	}

	public void setMnc(MNC mnc) {
		this.mnc = mnc;
	}

	@XmlTransient
	public Duration getDuration() {
		return duration;
	}

	@XmlTransient
	public CellHier getCell() {
		return cell;
	}

	public void setCell(CellHier cell) {
		this.cell = cell;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	@XmlTransient
	public EventCause getEvent() {
		return cause;
	}

	public void setEvent(EventCause cause) {
		this.cause = cause;
	}

	@XmlTransient
	public NEVersion getNe() {
		return ne;
	}

	public void setNe(NEVersion ne) {
		this.ne = ne;
	}

	@XmlTransient
	public IMSI getImsi() {
		return imsi;
	}

	public void setImsi(IMSI imsi) {
		this.imsi = imsi;
	}
}
