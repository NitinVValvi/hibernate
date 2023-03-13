package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher {
	@Id
	private int tid;
	private String tname;
	@OneToMany (targetEntity = Student.class, cascade = CascadeType.ALL,mappedBy = "t")
	Set<Student> s = new HashSet<>();
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Set<Student> getS() {
		return s;
	}
	public void setS(Set<Student> s) {
		this.s = s;
	}
	
}
