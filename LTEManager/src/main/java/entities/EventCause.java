package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@SuppressWarnings("serial")
@Entity
@Table(name = "event_cause")
public class EventCause implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "event")
	private Integer event;
	@Column(name = "description")
	private String description;
	@JoinColumn(name = "event_id", referencedColumnName = "event_id", nullable = false)
	@ManyToOne
	private EventId eventId;
	@OneToMany(mappedBy = "event")
	private List<Fault> faultList = new ArrayList<Fault>();

	public EventCause() {
	}

	public EventCause(Integer event, String description, EventId eventId) {
		this.event = event;
		this.description = description;
		this.eventId = eventId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEvent() {
		return event;
	}

	public void setEvent(Integer event) {
		this.event = event;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlTransient
	public EventId getEventId() {
		return eventId;
	}

	public void setEventId(EventId eventId) {
		this.eventId = eventId;
	}
	public void addFault(Fault fault) {
		fault.setEvent(this);
		faultList.add(fault);
	}
}