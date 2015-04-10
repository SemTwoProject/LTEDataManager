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
public class InvalidFault implements Serializable {

	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "date_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@Column(name = "ne")
	private String ne;
	@Column(name = "imsi")
	private String imsi;
	@Column(name = "duration")
	private String duration;
	@Column(name = "failure")
	private String failure;
	@Column(name = "tac")
	private String tac;
	@Column(name = "mcc")
	private String mcc;
	@Column(name = "mnc")
	private String mnc;
	@Column(name = "cell")
	private String cell;
	@Column(name = "eventid")
	private String eventId;
	@Column(name = "causeCode")
	private String causeCode;

	public InvalidFault() {
	}
	
	public InvalidFault(Integer id, Date date, String eventId, String failure, String tac,
			String mcc, String mnc, String cell, String duration,
			String causeid, String ne, String imsi) {

		this.id = id;
		this.date = date;
		this.eventId = eventId;
		this.failure = failure;
		this.tac = tac;
		this.mcc = mcc;
		this.mnc = mnc;
		this.cell = cell;
		this.duration = duration;
		this.causeCode = causeid;
		this.ne = ne;
		this.imsi = imsi;
	}

}