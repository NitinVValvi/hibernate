package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Student {
	@Id
	private int sid;
	private String sname;
	@ManyToMany (cascade = CascadeType.ALL)
	private Set<Staff> st = new HashSet<>();
	public Set<Staff> getSt() {
		return st;
	}
	public void setSt(Set<Staff> st) {
		this.st = st;
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
