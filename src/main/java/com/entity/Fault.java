package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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

	@Column(name = "ne")
	private String ne;
	@Column(name = "imsi")
	private Long imsi;
	@Column(name = "duration")
	private Integer duration;

	@JoinColumn(name = "failure", referencedColumnName = "failure")
	@ManyToOne
	private Failure failure;
	@JoinColumn(name = "tac", referencedColumnName = "tac")
	@ManyToOne
	private UE tac;

	@JoinColumns({ @JoinColumn(name = "mcc", referencedColumnName = "mcc"),
			@JoinColumn(name = "mnc", referencedColumnName = "mnc") })
	@ManyToOne
	private MccMnc mccid;

	@JoinColumn(name = "cell", referencedColumnName = "cell")
	@ManyToOne
	private CellHier cell;

	@JoinColumns({ @JoinColumn(name = "event_cause", referencedColumnName = "cause"),
	@JoinColumn(name = "event_id", referencedColumnName = "event_id") })
	@ManyToOne
	private EventCause eventCause;

	public Fault() {
	}

	public Fault(Date date, Integer eventId, Integer failure, Integer tac,
			Integer mcc, Integer mnc, Integer cell, Integer duration,
			Integer causeid, String ne, Long imsi) {

		this.date = date;
		this.eventCause = new EventCause();
		this.eventCause.setEventId(eventId);
		this.eventCause.setCauseCode(causeid);
		this.mccid = new MccMnc();
		this.mccid.setMccId(mcc);
		this.mccid.setMncId(mnc);
		this.failure = new Failure();
		this.failure.setfailure(failure);
		this.tac = new UE();
		this.tac.setTac(tac);
		this.cell = new CellHier();
		this.cell.setCellId(cell);
		this.duration = duration;
		this.ne = ne;
		this.imsi = imsi;
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

	public String getNe() {
		return ne;
	}

	public void setNe(String ne) {
		this.ne = ne;
	}

	public Long getImsi() {
		return imsi;
	}

	public void setImsi(Long imsi) {
		this.imsi = imsi;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
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
	public MccMnc getMccid() {
		return mccid;
	}

	public void setMccid(MccMnc mccid) {
		this.mccid = mccid;
	}

	@XmlTransient
	public CellHier getCell() {
		return cell;
	}

	public void setCell(CellHier cell) {
		this.cell = cell;
	}

	@XmlTransient
	public EventCause getEventCause() {
		return eventCause;
	}

	public void setEventCause(EventCause eventCause) {
		this.eventCause = eventCause;
	}

}
