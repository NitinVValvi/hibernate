package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	private int sid;
	private String sname;
	@OneToOne (cascade = CascadeType.ALL)
	private PanCard p;
	public int getsid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public PanCard getP() {
		return p;
	}
	public void setP(PanCard p) {
		this.p = p;
	}
}
