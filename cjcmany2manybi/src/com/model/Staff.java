package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Staff {
	@Id
	private int st_id;
	private String st_name;
	@ManyToMany (cascade = CascadeType.ALL)
	private Set<Student> student = new HashSet<>();
	public Set<Student> getStudent() {
		return student;
	}
	public void setStudent(Set<Student> student) {
		this.student = student;
	}
	@ManyToOne (cascade = CascadeType.ALL)
	private CJC cjc;
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

	public CJC getCjc() {
		return cjc;
	}
	public void setCjc(CJC cjc) {
		this.cjc = cjc;
	}
}
