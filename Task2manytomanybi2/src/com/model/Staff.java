package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Staff {
	@Id
	private int st_id;
	private String st_name;
	@ManyToMany (cascade = CascadeType.ALL)
	private Set<Student> s =  new HashSet<>();
	public Set<Student> getS() {
		return s;
	}
	public void setS(Set<Student> s) {
		this.s = s;
	}
	public int getSt_id() {
		return st_id;
	}
	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	
}
