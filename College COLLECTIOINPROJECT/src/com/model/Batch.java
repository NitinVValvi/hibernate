package com.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Batch {
@Id
	private int bid;
private String bname;
@ManyToMany (cascade = CascadeType.ALL)
private Set<Faculty> faculty = new HashSet<Faculty>();
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
@Override
public String toString() {
	return "Batch id = " + getBid() + "\nBatch name=" + getBname();
}



}
