package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Simcard {
@Id
	private int sid;
	private String sname;
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name ="mobileid")
	private Mobile mobile;
	public Mobile getMobile() {
		return mobile;
	}
	public void setT(Mobile mobile) {
		this.mobile = mobile;
	}
	public int getSid() {
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
	
}
