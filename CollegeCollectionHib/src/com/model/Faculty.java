package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table (name="FACULTY")
public class Faculty {
	@Id
	//@Column (name ="FACULTY_ID")
	private int fid;
	private String fname;
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "COURSE_ID")
	private Course course;
	@ManyToOne
	//@JoinColumn (name ="BATCH_ID")
	private Batch batch;
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
