package com.model;



import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;


import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate

public class Course {
	@Id
	
	private int cid;
	private String cname;
	@OneToMany (cascade = CascadeType.ALL)
	private Set<Faculty> faculty= new HashSet<Faculty>();
	
	public Set<Faculty> getFaculty() {
		return faculty;
	}
	public void setFaculty(Set<Faculty> faculty) {
		this.faculty = faculty;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Course [getCid()=" + getCid() + ", getCname()=" + getCname() + "]";
	}

}
