package com.entity;

import java.io.Serializable;
<<<<<<< HEAD
//import java.util.Date;
=======
import java.util.Date;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
<<<<<<< HEAD
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
=======
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
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
<<<<<<< HEAD
	// @Temporal(TemporalType.DATE)
	private String date;
=======
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
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
<<<<<<< HEAD
	@JoinColumn(name = "event_cause", referencedColumnName = "event", nullable = false)
	@ManyToOne
	private EventCause event;
=======
	@JoinColumn(name = "cause", referencedColumnName = "cause", nullable = false)
	@ManyToOne
	private EventCause cause;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
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
<<<<<<< HEAD

	public Fault(String date, EventId eventId, Failure failure, UE tac,
			MCC mcc, MNC mnc, CellHier cell, Duration duration,
			EventCause eventCause, NEVersion ne) {
=======
	
	public Fault(Date date, EventId eventId, Failure failure, UE tac,
			MCC mcc, MNC mnc, CellHier cell, Duration duration,
			EventCause eventCause, NEVersion ne, IMSI imsi) {
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
		this.date = date;
		this.eventId = eventId;
		this.failure = failure;
		this.tac = tac;
		this.mcc = mcc;
		this.mnc = mnc;
		this.cell = cell;
		this.duration = duration;
<<<<<<< HEAD
		this.event = eventCause;
		this.ne = ne;
=======
		this.cause = eventCause;
		this.ne = ne;
		this.imsi = imsi;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

<<<<<<< HEAD
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
=======
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setDate(Date date) {
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
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
<<<<<<< HEAD
		return event;
	}

	public void setEvent(EventCause event) {
		this.event = event;
=======
		return cause;
	}

	public void setEvent(EventCause cause) {
		this.cause = cause;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
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
