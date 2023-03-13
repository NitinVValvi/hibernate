package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Mobile {
	@Id
	private int mid;
	private String mname;
	@OneToMany (targetEntity = Simcard.class, cascade = CascadeType.ALL,mappedBy = "mobile")
	Set<Simcard> sim = new HashSet<>();
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Set<Simcard> getSim() {
		return sim;
	}
	public void setSim(Set<Simcard> sim) {
		this.sim = sim;
	}
	
}
