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
	//@Temporal(TemporalType.TIMESTAMP)
	private String date;
	
	@Column(name = "event_id")
	private Integer eventId;
	@JoinColumn(name = "failure", referencedColumnName = "failure_id", nullable = false)
	@ManyToOne
	private Failure failureid;
	@JoinColumn(name = "tac", referencedColumnName = "tac", nullable = false)
	@ManyToOne
	private UE tac;
	@JoinColumn(name = "market", referencedColumnName = "mcc_id", nullable = false)
	@ManyToOne
	private MccMnc mccid;
	@JoinColumn(name = "cell_id", referencedColumnName = "cell_id", nullable = false)
	@ManyToOne
	private CellHier cell_id;
	@JoinColumn(name = "cause", referencedColumnName = "cause_id", nullable = false)
	@ManyToOne
	private EventCause causeid;
	
	@Column(name = "ne")
	private String ne;
	@Column(name = "imsi")
	private Long imsi;
	@Column(name = "operator")
	private Integer mnc;
	@Column(name = "duration")
	private Integer duration;
	

	public Fault() {
	}
	
	public Fault(String date, Integer eventId, Failure failureid, UE tac,
			MccMnc mccid, Integer mnc, CellHier cell_id, Integer duration,
			EventCause causeid, String ne, Long imsi) {
		this.date = date;
		this.eventId = eventId;
		this.failureid = failureid;
		this.tac = tac;
		this.mccid = mccid;
		this.mnc = mnc;
		this.cell_id = cell_id;
		this.duration = duration;
		this.causeid = causeid;
		this.ne = ne;
		this.imsi = imsi;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	//@Temporal(TemporalType.TIMESTAMP)
	public String getDate() {
		return date;
	}

	//@Temporal(TemporalType.TIMESTAMP)
	public void setDate(String date) {
		this.date = date;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	@XmlTransient
	public Failure getFailure() {
		return failureid;
	}

	public void setFailure(Failure failureid) {
		this.failureid = failureid;
	}

	@XmlTransient
	public UE getTac() {
		return tac;
	}

	public void setTac(UE tac) {
		this.tac = tac;
	}

	@XmlTransient
	public MccMnc getMcc() {
		return mccid;
	}

	public void setMcc(MccMnc mccid) {
		this.mccid = mccid;
	}

	public Integer getMnc() {
		return mnc;
	}

	public void setMnc(Integer mnc) {
		this.mnc = mnc;
	}

	public Integer getDuration() {
		return duration;
	}

	@XmlTransient
	public CellHier getCell() {
		return cell_id;
	}

	public void setCell(CellHier cell_id) {
		this.cell_id = cell_id;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@XmlTransient
	public EventCause getEvent() {
		return causeid;
	}

	public void setEvent(EventCause causeid) {
		this.causeid = causeid;
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
}
