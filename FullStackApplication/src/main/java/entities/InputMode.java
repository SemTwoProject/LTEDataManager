package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "input_mode")
public class InputMode implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "input_mode")
	private String inputMode;

	@OneToMany(mappedBy = "inputMode", cascade = CascadeType.ALL)
	private List<UE> ueList = new ArrayList<UE>();

	public InputMode() {
		// TODO Auto-generated constructor stub
	}

	public InputMode(String inputMode) {
		this.inputMode = inputMode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInputMode() {
		return inputMode;
	}

	public void setInputMode(String inputMode) {
		this.inputMode = inputMode;
	}

	public List<UE> getUeList() {
		return ueList;
	}

	public void setUeList(List<UE> ueList) {
		this.ueList = ueList;
	}

	public void addUE(UE ue) {
		ue.setInputMode(this);
		ueList.add(ue);
	}
}
