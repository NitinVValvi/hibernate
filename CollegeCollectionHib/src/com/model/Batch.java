package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Batch {
	@Id
	@GeneratedValue
	private int bid;
	private String bname;
	@OneToMany (cascade = CascadeType.ALL)
	private Set<Faculty> faculty = new HashSet<Faculty>();
	@OneToMany (cascade = CascadeType.ALL)
	private Set<Student> student = new HashSet<Student>();
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public Set<Faculty> getFaculty() {
		return faculty;
	}
	public void setFaculty(Set<Faculty> faculty) {
		this.faculty = faculty;
	}
	public Set<Student> getStudent() {
		return student;
	}
	public void setStudent(Set<Student> student) {
		this.student = student;
	}
	
}
