package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Staff {
	@Id
	private int staff_id;
	private String staff_name;
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "cjcclassid")
	private CJC cjc;
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public CJC getCjc() {
		return cjc;
	}
	public void setCjc(CJC cjc) {
		this.cjc = cjc;
	}
}
