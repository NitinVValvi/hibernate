package com.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Faculty {
@Id
private int fid;
private String fname;
@ManyToMany (cascade = CascadeType.ALL)
private Set<Course> course = new HashSet<Course>();
public int getFid() {
	return fid;
}
public void setFid(int fid) {
	this.fid = fid;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public Set<Course> getCourse() {
	return course;
}
public void setCourse(Set<Course> course) {
	this.course = course;
}
@Override
public String toString() {
	return "Faculty id = " + getFid()
			+ "\nFaculty name =" + getFname() + "]";
}



}
