package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Student {
	@Id
	private int sid;
	private String sname;
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "cjcclassid")
	private CJC cjc;
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
	public CJC getCjc() {
		return cjc;
	}
	public void setCjc(CJC cjc) {
		this.cjc = cjc;
	}
}
