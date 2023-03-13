package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PanCard {
	@Id
	private int pan_id;
	private String pan_name;
	@OneToOne (cascade = CascadeType.ALL,mappedBy = "p")
	private Student stud;
	public int getPan_id() {
		return pan_id;
	}
	public void setPan_id(int pan_id) {
		this.pan_id = pan_id;
	}
	public String getPan_name() {
		return pan_name;
	}
	public void setPan_name(String pan_name) {
		this.pan_name = pan_name;
	}
}
