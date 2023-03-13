package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Batch {
	@Id
private int bid;
private String bname;
@OneToMany (cascade = CascadeType.ALL)
private Faculty faculty;
@ManyToMany (cascade = CascadeType.ALL)
private List<Batch> blist = new ArrayList<>();
public List<Batch> getBlist() {
	return blist;
}
public void setBlist(List<Batch> blist) {
	this.blist = blist;
}
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
public Faculty getFaculty() {
	return faculty;
}
public void setFaculty(Faculty faculty) {
	this.faculty = faculty;
}

}
