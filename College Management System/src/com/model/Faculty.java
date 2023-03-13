package com.model;


import java.util.ArrayList;
import java.util.List;

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
	private Course course;
	@ManyToMany (cascade = CascadeType.ALL)
	private List<Faculty> flist = new ArrayList<>();
	public List<Faculty> getFlist() {
		return flist;
	}
	public void setFlist(List<Faculty> flist) {
		this.flist = flist;
	}
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
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}

}
